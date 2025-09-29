// package com.qualco.casestudy.specifications;

// import org.springframework.data.jpa.domain.Specification;

// import com.qualco.casestudy.model.Country;
// import com.qualco.casestudy.model.CountryStat;
// import com.qualco.casestudy.model.Region;

// import jakarta.persistence.criteria.*;

// public class CountryStatFilter {

//     private CountryStatFilter() {
//         // Prevent instantiation
//     }

//     public static Specification<CountryStat> byRegionAndYear(Long regionId, Integer yearFrom, Integer yearTo) {
//         return (Root<CountryStat> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {

//             Join<CountryStat, Country> countryJoin = root.join("country");
//             Join<Country, Region> regionJoin = countryJoin.join("region");

//             Predicate predicate = criteriaBuilder.conjunction(); // always true

//             if (regionId != null) {
//                 predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(regionJoin.get("regionId"), regionId));
//             }
//             if (yearFrom != null) {
//                 predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("year"), yearFrom));
//             }
//             if (yearTo != null) {
//                 predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(root.get("year"), yearTo));
//             }

//             return predicate;
//         };
//     }
// }
