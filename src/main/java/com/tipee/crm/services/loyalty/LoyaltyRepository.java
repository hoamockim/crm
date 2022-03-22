package com.tipee.crm.services.loyalty;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LoyaltyRepository extends R2dbcRepository<Loyalty, Integer> {
    @Query("select * from loyalty where id=$1 order by updated_at desc LIMIT $2 OFFSET $3")
    Flux<Loyalty> getWithPageable(Integer campaignId, int limit, long offset);

    @Query("select * from loyalty where code=$1 LIMIT 1")
    Mono<Loyalty> getByCode(String code);
}
