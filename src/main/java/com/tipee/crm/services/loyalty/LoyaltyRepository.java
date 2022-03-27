package com.tipee.crm.services.loyalty;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface LoyaltyRepository extends R2dbcRepository<Loyalty, Integer> {
    @Query("select * from loyalty where id=$1 order by updated_at desc LIMIT $2 OFFSET $3")
    Flux<Loyalty> getWithPageable(Integer campaignId, int limit, long offset);

    @Query("select * from loyalty where code=$1 LIMIT 1")
    Mono<Loyalty> getByCode(String code);

    @Query("update loyalty set deleted=true where code = $1")
    Mono<Boolean> delete(String code);
}
