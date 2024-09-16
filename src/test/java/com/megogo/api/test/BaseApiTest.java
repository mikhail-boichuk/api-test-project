package com.megogo.api.test;

import com.megogo.client.MegogoApiClient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseApiTest {

    protected final MegogoApiClient client = new MegogoApiClient();

}
