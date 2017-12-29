/**
 * Created by Andrew Bell 12/29/17
 * www.recursivechaos.com
 * andrew@recursivechaos.com
 * Licensed under MIT License 2017. See license.txt for details.
 */

package com.recursivechaos.profile.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProfileTest {

    @Test
    public void allArgsConstructor() {
        final String TEST_DISPLY_NAME = "Andrew Bell";
        final String TEST_EMAIL = "myemail@domain.com";
        final String TEST_LOCATION = "D14";
        final String TEST_TITLE = "Cloud Native Developer";

        Profile testProfile = new Profile(TEST_DISPLY_NAME, TEST_EMAIL, TEST_LOCATION, TEST_TITLE);

        assertEquals(testProfile.getDisplayName(), TEST_DISPLY_NAME);
        assertEquals(testProfile.getEmail(), TEST_EMAIL);
        assertEquals(testProfile.getLocation(), TEST_LOCATION);
        assertEquals(testProfile.getTitle(), TEST_TITLE);
    }
}