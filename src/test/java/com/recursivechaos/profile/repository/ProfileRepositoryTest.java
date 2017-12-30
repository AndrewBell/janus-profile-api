/**
 * Created by Andrew Bell 12/29/17
 * www.recursivechaos.com
 * andrew@recursivechaos.com
 * Licensed under MIT License 2017. See license.txt for details.
 */

package com.recursivechaos.profile.repository;

import com.recursivechaos.profile.ProfileApiApplication;
import com.recursivechaos.profile.models.Profile;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static com.recursivechaos.profile.TestData.*;
import static org.junit.Assert.*;

@SpringBootTest(classes = ProfileApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ProfileRepositoryTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProfileRepository profileRepository;

    @Before
    public void setUp() throws Exception {
        List<Profile> profiles = Arrays.asList(new Profile(1L, TEST_DISPLAY_NAME, TEST_EMAIL, TEST_LOCATION, TEST_TITLE));

        profileRepository.saveAll(profiles);
    }

    @Test
    public void shouldReturnAllProfiles() throws Exception {
        this.mockMvc
            .perform(MockMvcRequestBuilders.get("/v1/profiles"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/hal+json;charset=UTF-8"))
            .andExpect(MockMvcResultMatchers.jsonPath("@._embedded.profiles.[0].displayName").value(TEST_DISPLAY_NAME));
    }
}