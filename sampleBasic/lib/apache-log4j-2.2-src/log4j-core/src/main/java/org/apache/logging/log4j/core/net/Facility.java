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
package org.apache.logging.log4j.core.net;

import org.apache.logging.log4j.util.EnglishEnums;

/**
 *  The facility codes used by the Syslog system.
 *
 *        Numerical          Facility<br>
 *           Code<br>
 *
 *             0             kernel messages<br>
 *             1             user-level messages<br>
 *             2             mail system<br>
 *             3             system daemons<br>
 *             4             security/authorization messages<br>
 *             5             messages generated internally by syslogd<br>
 *             6             line printer subsystem<br>
 *             7             network news subsystem<br>
 *             8             UUCP subsystem<br>
 *             9             clock daemon<br>
 *            10             security/authorization messages<br>
 *            11             FTP daemon<br>
 *            12             NTP subsystem<br>
 *            13             log audit<br>
 *            14             log alert<br>
 *            15             clock daemon (note 2)<br>
 *            16             local use 0  (local0)<br>
 *            17             local use 1  (local1)<br>
 *            18             local use 2  (local2)<br>
 *            19             local use 3  (local3)<br>
 *            20             local use 4  (local4)<br>
 *            21             local use 5  (local5)<br>
 *            22             local use 6  (local6)<br>
 *            23             local use 7  (local7)<br>
 */
public enum Facility {
    /** Kernel messages. */
    KERN(0),
    /** User level messages. */
    USER(1),
    /** Mail system. */
    MAIL(2),
    /** System daemons. */
    DAEMON(3),
    /** Security/Authorization messages. */
    AUTH(4),
    /** Messages generated by syslogd. */
    SYSLOG(5),
    /** Line printer subsystem. */
    LPR(6),
    /** Network news subsystem. */
    NEWS(7),
    /** UUCP subsystem. */
    UUCP(8),
    /** Clock daemon. */
    CRON(9),
    /** Security/Authorization messages. */
    AUTHPRIV(10),
    /** FTP daemon. */
    FTP(11),
    /** NTP subsystem. */
    NTP(12),
    /** Log audit. */
    LOG_AUDIT(13),
    /** Log alert. */
    LOG_ALERT(14),
    /** Clock daemon. */
    CLOCK(15),
    /** Local use 0. */
    LOCAL0(16),
    /** Local use 1. */
    LOCAL1(17),
    /** Local use 2. */
    LOCAL2(18),
    /** Local use 3. */
    LOCAL3(19),
    /** Local use 4. */
    LOCAL4(20),
    /** Local use 5. */
    LOCAL5(21),
    /** Local use 6. */
    LOCAL6(22),
    /** Local use 7. */
    LOCAL7(23);

    private final int code;

    private Facility(final int code) {
        this.code = code;
    }

    /**
     * Returns the Facility for the given string.
     *
     * @param name The Facility enum name, case-insensitive. If null, returns, null
     * @return a Facility enum value or null if name is null
     */
    public static Facility toFacility(final String name) {
        return toFacility(name, null);
    }

    /**
     * Returns the Facility for the given string.
     *
     * @param name The Facility enum name, case-insensitive. If null, returns, defaultFacility
     * @param defaultFacility the Facility to return if name is null
     * @return a Facility enum value or null if name is null
     */
    public static Facility toFacility(final String name, final Facility defaultFacility) {
        return EnglishEnums.valueOf(Facility.class, name, defaultFacility);
    }

    /**
     * Retrieve the value of the enumeration.
     * @return The value associated with the enumeration.
     */
    public int getCode() {
        return this.code;
    }

    /**
     * Determine if this enumeration matches the specified name (ignoring case).
     * @param name The name to check.
     * @return true if the name matches this enumeration, ignoring case.
     */
    public boolean isEqual(final String name) {
        return this.name().equalsIgnoreCase(name);
    }

}