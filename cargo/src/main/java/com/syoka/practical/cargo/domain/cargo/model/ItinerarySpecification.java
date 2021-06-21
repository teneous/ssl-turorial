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
package com.syoka.practical.cargo.domain.cargo.model;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.syoka.practical.cargo.domain.shared.Specification;

/**
 * @author syoka
 * @version : ItinerarySpecification.java 2021年05月31日 16时46分
 */
@Service
public class ItinerarySpecification implements Specification {

    public Itinerary evaluate(List<Itinerary> itineraries) {
        return itineraries.stream().min(Comparator.comparingInt(Itinerary::getCostTime)).orElse(null);
    }
}
