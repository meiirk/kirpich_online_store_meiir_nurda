package com.example.kirpich_online_store_meiir_nurda.brick.endpoint;

import com.example.kirpich_online_store_meiir_nurda.brick.repository.BrickRepository;
import io.spring.guides.gs_producing_web_service.GetBrickRequest;
import io.spring.guides.gs_producing_web_service.GetBrickResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class BrickEndPoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private final BrickRepository brickRepository;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBrickRequest")
    @ResponsePayload
    public GetBrickResponse getCountry(@RequestPayload GetBrickRequest request) {
        GetBrickResponse response = new GetBrickResponse();
        response.setBrick(brickRepository.findBrick(request.getName()));

        return response;
    }
}
