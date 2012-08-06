/* Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kjots.lib.gwt.client.org.apache.harmony.luni.tests.java.net;

import java.net.URISyntaxException;

import org.kjots.lib.gwt.client.UriEmulGwtTestBase;

/**
 * Modified for use in <em>GWT</em> by <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>:
 * <ul>
 * <li>Moved into org.kjots.lib.gwt.client.org.apache.harmony.luni.tests.java.net package</li>
 * <li>Renamed to URISyntaxExceptionGwtTest</li>
 * <li>Updated to extend org.kjots.lib.gwt.client.UriEmulGwtTestBase</li>
 * <li>Updated test_getMessage() method to not set locale</li>
 * </ul>
 */
public class URISyntaxExceptionGwtTest extends UriEmulGwtTestBase {

    /**
     * @tests java.net.URISyntaxException#URISyntaxException(java.lang.String,
     *        java.lang.String, int)
     */
    public void test_ConstructorLjava_lang_StringLjava_lang_StringI() {
        try {
            new URISyntaxException(null, "problem", 2);
            fail("Expected NullPointerException");
        } catch (NullPointerException npe) {
            // Expected
        }

        try {
            new URISyntaxException("str", null, 2);
            fail("Expected NullPointerException");
        } catch (NullPointerException npe) {
            // Expected
        }

        try {
            new URISyntaxException("str", "problem", -2);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException iae) {
            // Expected
        }

        URISyntaxException e = new URISyntaxException("str", "problem", 2);
        assertEquals("returned incorrect reason", "problem", e.getReason());
        assertEquals("returned incorrect input", "str", e.getInput());
        assertEquals("returned incorrect index", 2, e.getIndex());
    }

    /**
     * @tests java.net.URISyntaxException#URISyntaxException(java.lang.String,
     *        java.lang.String)
     */
    public void test_ConstructorLjava_lang_StringLjava_lang_String() {
        try {
            new URISyntaxException(null, "problem");
            fail("Expected NullPointerException");
        } catch (NullPointerException npe) {
            // Expected
        }

        try {
            new URISyntaxException("str", null);
            fail("Expected NullPointerException");
        } catch (NullPointerException npe) {
            // Expected
        }

        URISyntaxException e = new URISyntaxException("str", "problem");
        assertEquals("returned incorrect reason", "problem", e.getReason());
        assertEquals("returned incorrect input", "str", e.getInput());
        assertEquals("returned incorrect index", -1, e.getIndex());
    }

    /**
     * @tests java.net.URISyntaxException#getIndex()
     */
    public void test_getIndex() {
        // see constructor tests
    }

    /**
     * @tests java.net.URISyntaxException#getReason()
     */
    public void test_getReason() {
        // see constructor tests
    }

    /**
     * @tests java.net.URISyntaxException#getInput()
     */
    public void test_getInput() {
        // see constructor tests
    }

    /**
     * @tests java.net.URISyntaxException#getMessage()
     */
    public void test_getMessage() {
        URISyntaxException e = new URISyntaxException("str", "problem", 3);
        assertEquals("Returned incorrect message", "problem at index 3: str", e
                .getMessage());

        e = new URISyntaxException("str", "problem");
        assertEquals("Returned incorrect message", "problem: str", e
                .getMessage());
    }
}