/*
 *  Copyright (C), 2008-2021, Syoka All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.syoka.practical.cargo.infrastructure.client.itinerary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.syoka.practical.cargo.domain.cargo.model.CargoSpecification;
import com.syoka.practical.cargo.domain.cargo.model.Itinerary;
import com.syoka.practical.cargo.domain.cargo.service.ItineraryService;
import com.syoka.practical.itinerary.api.ItineraryClient;
import com.syoka.practical.itinerary.api.dto.ItineraryPlan;

import feign.Client;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import javax.annotation.Resource;

/**
 * @author syoka
 * @version : ItineraryServiceClient.java 2021年05月31日 16时56分
 */
@Component
public class ItineraryServiceClient implements ItineraryService {

    @Resource
    private Client okhttp3Client;

    @Override
    public List<Itinerary> getItinerary(CargoSpecification specification) {

        ItineraryClient itineraryClient = Feign.builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .client(okhttp3Client)
                .target(ItineraryClient.class, "https://itinerary.syoka.com:9003");

        List<ItineraryPlan> itineraries = itineraryClient.getItinerary();
        if (CollectionUtils.isEmpty(itineraries)) {
            return Collections.emptyList();
        }

        List<Itinerary> result = new ArrayList<>(itineraries.size());

        for (ItineraryPlan plan : itineraries) {
            Itinerary itinerary = new Itinerary();
            itinerary.setCostTime(plan.getCostTime());
            itinerary.setSupplier(plan.getSupplier());
            result.add(itinerary);
        }
        return result;
    }
}
