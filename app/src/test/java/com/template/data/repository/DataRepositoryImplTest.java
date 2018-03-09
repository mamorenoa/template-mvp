package com.template.data.repository;

import com.template.BuildConfig;
import com.template.data.FilmsRepositoryImpl;
import com.template.data.common.MockApiReponse;
import com.template.data.common.TestNetworkModule;
import com.template.data.exceptions.ConnectionException;
import com.template.domain.model.Film;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.SocketPolicy;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23)
public class DataRepositoryImplTest extends MockWebServerTest {

    private TestNetworkModule networkModule;
    private FilmsRepositoryImpl dataRepository;


    public DataRepositoryImplTest() {
        networkModule = new TestNetworkModule();
    }

    @Before
    public void setUp() throws Exception {
        server = networkModule.getMockWebServer();
        dataRepository = new FilmsRepositoryImpl(networkModule.getApiService());
    }

    @After
    public void tearDown() throws Exception {
        server.shutdown();
    }

    @Test
    public void sendsContentTypeHeader() throws Exception {
        server.enqueue(MockApiReponse.serviceGetFilmsSuccess());
        dataRepository.getFilms();
        assertRequestContainsHeader("Content-Type", "application/json");
    }

    @Test
    public void sendsAcceptHeader() throws Exception {
        server.enqueue(MockApiReponse.serviceGetFilmsSuccess());
        dataRepository.getFilms();
        assertRequestContainsHeader("Accept", "application/json");
    }

    @Test
    public void sendsPostRequestToTheCorrectEndpoint() throws Exception {
        server.enqueue(MockApiReponse.serviceGetFilmsSuccess());
        dataRepository.getFilms();
        assertPostRequestSentTo("/test-service");
    }

    @Test
    public void parseDataProperly() throws Exception {
        server.enqueue(MockApiReponse.serviceGetFilmsSuccess());
        dataRepository.getFilms();
        //assertServiceDataContainsExpectedValues(testServiceData);
    }

    @Test(expected = ConnectionException.class)
    public void shouldNetworkExceptionWhenTimeOut() throws Exception {
        server.enqueue(new MockResponse().setSocketPolicy(SocketPolicy.NO_RESPONSE));
        dataRepository.getFilms();
    }

    @Test(expected = ConnectionException.class)
    public void shouldNetworkExceptionWhenCertificateHandsake() throws Exception {
        server.enqueue(new MockResponse().setSocketPolicy(SocketPolicy.FAIL_HANDSHAKE));
        dataRepository.getFilms();
    }

    //TODO:
    private void assertServiceDataContainsExpectedValues(Film testServiceData) {
        assertEquals(testServiceData.getDirector(), "");
        assertEquals(testServiceData.getId(), "");
    }
}
