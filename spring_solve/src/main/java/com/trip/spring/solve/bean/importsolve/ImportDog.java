package com.trip.spring.solve.bean.importsolve;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author xbguo
 * @date 2023/2/1 10:44
 */
public class ImportDog implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{Dog.class.getName()};
    }
}
