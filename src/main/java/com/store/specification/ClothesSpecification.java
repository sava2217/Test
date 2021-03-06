package com.store.specification;

import com.store.entity.Clothes;
import com.store.filter.ClothesFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ClothesSpecification implements Specification<Clothes> {
    private final ClothesFilter filter;

    private static final Pattern REG = Pattern.compile("^([0-9]{1,17}\\.[0-9]{1,2})|([0-9]{1,17}\\,[0-9]{1,2})|([0-9]{1,17})$");

    private final List<Predicate> predicates = new ArrayList<>();


    public ClothesSpecification(ClothesFilter filter) {
        this.filter = filter;
        if (REG.matcher(filter.getMax()).matches()) {
            filter.setMaxValue(new BigDecimal(filter.getMax().replace(',', '.')));
        }
        if (REG.matcher(filter.getMin()).matches()) {
            filter.setMinValue(new BigDecimal(filter.getMin().replace(',', '.')));
        }

    }

    private void findByPrice(Root<Clothes> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (filter.getMaxValue() != null) {
            predicates.add(cb.le(root.get("price"), filter.getMaxValue()));
        }
        if (filter.getMinValue() != null) {
            predicates.add(cb.ge(root.get("price"), filter.getMinValue()));
        }

    }

    private void findByColor(Root<Clothes> root, CriteriaQuery<?> query) {
        if (!filter.getColorId().isEmpty()) {
            predicates.add(root.get("color").in(filter.getColorId()));
        }
    }

    private void findByBrand(Root<Clothes> root, CriteriaQuery<?> query) {
        if (!filter.getBrandId().isEmpty()) {
            predicates.add(root.get("brand").in(filter.getBrandId()));
        }
    }

    private void findByGender(Root<Clothes> root, CriteriaQuery<?> query) {
        if (!filter.getGenderId().isEmpty()) {
            predicates.add(root.get("gender").in(filter.getGenderId()));
        }
    }

    private void findBySeason(Root<Clothes> root, CriteriaQuery<?> query) {
        if (!filter.getSeasonId().isEmpty()) {
            predicates.add(root.get("season").in(filter.getSeasonId()));
        }
    }
    private void findByClothesMaterial(Root<Clothes> root, CriteriaQuery<?> query) {
        if (!filter.getClothesMaterialId().isEmpty()) {
            predicates.add(root.get("clothesMaterial").in(filter.getClothesMaterialId()));
        }
    }
    private void findByClothesSize(Root<Clothes> root, CriteriaQuery<?> query) {
        if (!filter.getClothesSizeId().isEmpty()) {
            predicates.add(root.get("clothesSize").in(filter.getClothesSizeId()));
        }
    }




    private void fetch(Root<Clothes> root, CriteriaQuery<?> query) {
        if (!query.getResultType().equals(Long.class)) {
            query.distinct(true);
            root.fetch("color");
            root.fetch("brand");
            root.fetch("gender");
            root.fetch("season");
            root.fetch("clothesMaterial");
            root.fetch("clothesSize");
        }
    }

    @Override
    public Predicate toPredicate(Root<Clothes> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        fetch(root, query);
        findByPrice(root, query, cb);
        findByColor(root, query);
        findByBrand(root, query);
        findByGender(root, query);
        findBySeason(root, query);
        findByClothesMaterial(root, query);
        findByClothesSize(root, query);

        if (predicates.isEmpty())
            return null;
        Predicate[] array = new Predicate[predicates.size()];
        array = predicates.toArray(array);
        return cb.and(array);
    }

}

