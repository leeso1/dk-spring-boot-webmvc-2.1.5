package me.learning;

import me.learning.bootstrap.IntegrationProperties;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class IntegrationPropertiesTest {

    @Autowired
    IntegrationProperties properties;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void listedPropertiesTest() {
        List<IntegrationProperties.IntegratedServerInformation> servers = properties.getServers();
        assertThat(servers.size()).isEqualTo(2);
        assertThat(servers.get(0).getBaseUrl()).isEqualTo("10.0.0.1");
    }

    @Test
    public void mappedPropertiesTest() {
        Map<String, IntegrationProperties.IntegratedServerInformation> map = properties.getMap();
        assertThat((map.size())).isEqualTo(2);
        assertThat(map.get("int1").getBaseUrl()).isEqualTo("10.0.0.3");
    }


}
