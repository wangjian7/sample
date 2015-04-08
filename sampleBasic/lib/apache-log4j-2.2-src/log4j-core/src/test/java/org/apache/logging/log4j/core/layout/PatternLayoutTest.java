/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache license, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the license for the specific language governing permissions and
 * limitations under the license.
 */
package org.apache.logging.log4j.core.layout;

import java.nio.charset.Charset;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.core.BasicConfigurationFactory;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.impl.Log4jLogEvent;
import org.apache.logging.log4j.core.util.Charsets;
import org.apache.logging.log4j.message.SimpleMessage;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class PatternLayoutTest {
    static ConfigurationFactory cf = new BasicConfigurationFactory();
    static String msgPattern = "%m%n";
    static String OUTPUT_FILE = "target/output/PatternParser";
    static final String regexPattern = "%replace{%logger %msg}{\\.}{/}";
    static String WITNESS_FILE = "witness/PatternParser";

    public static void cleanupClass() {
        ConfigurationFactory.removeConfigurationFactory(cf);
    }

    @BeforeClass
    public static void setupClass() {
        ConfigurationFactory.setConfigurationFactory(cf);
        final LoggerContext ctx = (LoggerContext) LogManager.getContext();
        ctx.reconfigure();
    }

    @After
    public void after() {
        ThreadContext.clearMap();

    }

    LoggerContext ctx = (LoggerContext) LogManager.getContext();

    Logger root = ctx.getLogger("");

    @Test
    public void testMdcPattern1() throws Exception {
        testMdcPattern("%m : %X", "Hello : {}", false);
    }

    @Test
    public void testMdcPattern2() throws Exception {
        testMdcPattern("%m : %X{key1}", "Hello : value1", true);
    }

    @Test
    public void testMdcPattern3() throws Exception {
        testMdcPattern("%m : %X{key2}", "Hello : value2", true);
    }

    @Test
    public void testMdcPattern4() throws Exception {
        testMdcPattern("%m : %X{key3}", "Hello : ", true);
    }

    @Test
    public void testMdcPattern5() throws Exception {
        testMdcPattern("%m : %X{key1}, %X{key2}, %X{key3}", "Hello : value1, value2, ", true);
    }

    private void testMdcPattern(final String patternStr, final String expectedStr, final boolean useThreadContext) throws Exception {
        final PatternLayout layout = PatternLayout.newBuilder().withPattern(patternStr)
                .withConfiguration(ctx.getConfiguration()).build();
        if (useThreadContext) {
            ThreadContext.put("key1", "value1");
            ThreadContext.put("key2", "value2");
        }
        final LogEvent event = new Log4jLogEvent(this.getClass().getName(), null,
                "org.apache.logging.log4j.core.Logger", Level.INFO, new SimpleMessage("Hello"), null);
        final byte[] result = layout.toByteArray(event);
        assertEquals(expectedStr, new String(result));
    }

    @Test
    public void testRegex() throws Exception {
        final PatternLayout layout = PatternLayout.newBuilder().withPattern(regexPattern)
                .withConfiguration(ctx.getConfiguration()).build();
        final LogEvent event = new Log4jLogEvent(this.getClass().getName(), null,
                "org.apache.logging.log4j.core.Logger", Level.INFO, new SimpleMessage("Hello, world!"), null);
        final byte[] result = layout.toByteArray(event);
        assertEquals("org/apache/logging/log4j/core/layout/PatternLayoutTest Hello, world!", new String(result));
    }

    private void testUnixTime(final String pattern) throws Exception {
        final PatternLayout layout = PatternLayout.newBuilder().withPattern(pattern + " %m")
                .withConfiguration(ctx.getConfiguration()).build();
        final LogEvent event1 = new Log4jLogEvent(this.getClass().getName(), null,
                "org.apache.logging.log4j.core.Logger", Level.INFO, new SimpleMessage("Hello, world 1!"), null);
        final byte[] result1 = layout.toByteArray(event1);
        assertEquals(event1.getTimeMillis() + " Hello, world 1!", new String(result1));
        // System.out.println("event1=" + event1.getMillis());
        final LogEvent event2 = new Log4jLogEvent(this.getClass().getName(), null,
                "org.apache.logging.log4j.core.Logger", Level.INFO, new SimpleMessage("Hello, world 2!"), null);
        final byte[] result2 = layout.toByteArray(event2);
        assertEquals(event2.getTimeMillis() + " Hello, world 2!", new String(result2));
        // System.out.println("event2=" + event2.getMillis());
    }

    @Test
    public void testUnixTime() throws Exception {
        final PatternLayout layout = PatternLayout.newBuilder().withPattern("%d{UNIX} %m")
                .withConfiguration(ctx.getConfiguration()).build();
        final LogEvent event1 = new Log4jLogEvent(this.getClass().getName(), null,
                "org.apache.logging.log4j.core.Logger", Level.INFO, new SimpleMessage("Hello, world 1!"), null);
        final byte[] result1 = layout.toByteArray(event1);
        assertEquals(event1.getTimeMillis() / 1000 + " Hello, world 1!", new String(result1));
        // System.out.println("event1=" + event1.getTimeMillis() / 1000);
        final LogEvent event2 = new Log4jLogEvent(this.getClass().getName(), null,
                "org.apache.logging.log4j.core.Logger", Level.INFO, new SimpleMessage("Hello, world 2!"), null);
        final byte[] result2 = layout.toByteArray(event2);
        assertEquals(event2.getTimeMillis() / 1000 + " Hello, world 2!", new String(result2));
        // System.out.println("event2=" + event2.getTimeMillis() / 1000);
    }

    @Test
    public void testUnixTimeMillis() throws Exception {
        final PatternLayout layout = PatternLayout.newBuilder().withPattern("%d{UNIX_MILLIS} %m")
                .withConfiguration(ctx.getConfiguration()).build();
        final LogEvent event1 = new Log4jLogEvent(this.getClass().getName(), null,
                "org.apache.logging.log4j.core.Logger", Level.INFO, new SimpleMessage("Hello, world 1!"), null);
        final byte[] result1 = layout.toByteArray(event1);
        assertEquals(event1.getTimeMillis() + " Hello, world 1!", new String(result1));
        // System.out.println("event1=" + event1.getTimeMillis());
        final LogEvent event2 = new Log4jLogEvent(this.getClass().getName(), null,
                "org.apache.logging.log4j.core.Logger", Level.INFO, new SimpleMessage("Hello, world 2!"), null);
        final byte[] result2 = layout.toByteArray(event2);
        assertEquals(event2.getTimeMillis() + " Hello, world 2!", new String(result2));
        // System.out.println("event2=" + event2.getTimeMillis());
    }

    @Test
    public void testHeaderFooterThreadContext() throws Exception {
        final PatternLayout layout = PatternLayout.newBuilder().withPattern("%d{UNIX} %m")
                .withConfiguration(ctx.getConfiguration()).withHeader("${ctx:header}").withFooter("${ctx:footer}")
                .build();
        ThreadContext.put("header", "Hello world Header");
        ThreadContext.put("footer", "Hello world Footer");
        final byte[] header = layout.getHeader();
        assertNotNull("No header", header);
        assertTrue("expected \"Hello world Header\", actual \"" + new String(header) + '"',
                new String(header).equals(new String("Hello world Header")));
    }

    @Test
    public void testHeaderFooterJavaLookup() throws Exception {
        // % does not work here.
        final String pattern = "%d{UNIX} MyApp%n${java:version}%n${java:runtime}%n${java:vm}%n${java:os}%n${java:hw}";
        final PatternLayout layout = PatternLayout.newBuilder().withConfiguration(ctx.getConfiguration())
                .withHeader(pattern).withFooter(pattern).build();
        final byte[] header = layout.getHeader();
        assertNotNull("No header", header);
        final String headerStr = new String(header);
        assertTrue(headerStr, headerStr.contains("Java version "));
        assertTrue(headerStr, headerStr.contains("(build "));
        assertTrue(headerStr, headerStr.contains(" from "));
        assertTrue(headerStr, headerStr.contains(" architecture: "));
        //
        final byte[] footer = layout.getFooter();
        assertNotNull("No header", footer);
        final String footerStr = new String(header);
        assertTrue(footerStr, footerStr.contains("Java version "));
        assertTrue(footerStr, footerStr.contains("(build "));
        assertTrue(footerStr, footerStr.contains(" from "));
        assertTrue(footerStr, footerStr.contains(" architecture: "));
    }

    @Test
    public void testSpecialChars() throws Exception {
        final PatternLayout layout = PatternLayout.newBuilder().withPattern("\\\\%level\\t%msg\\n\\t%logger\\r\\n\\f")
                .withConfiguration(ctx.getConfiguration()).build();
        final LogEvent event = new Log4jLogEvent(this.getClass().getName(), null,
                "org.apache.logging.log4j.core.Logger", Level.INFO, new SimpleMessage("Hello, world!"), null);
        final byte[] result = layout.toByteArray(event);
        assertEquals("\\INFO\tHello, world!\n\torg.apache.logging.log4j.core.layout.PatternLayoutTest\r\n\f",
                new String(result));
    }

    @Test
    public void testUsePlatformDefaultIfNoCharset() throws Exception {
        final PatternLayout layout = PatternLayout.newBuilder().withPattern("%m")
                .withConfiguration(ctx.getConfiguration()).build();
        assertEquals(Charset.defaultCharset(), layout.getCharset());
    }

    @Test
    public void testUseSpecifiedCharsetIfExists() throws Exception {
        final PatternLayout layout = PatternLayout.newBuilder().withPattern("%m")
                .withConfiguration(ctx.getConfiguration()).withCharset(Charsets.UTF_8).build();
        assertEquals(Charsets.UTF_8, layout.getCharset());
    }
}
