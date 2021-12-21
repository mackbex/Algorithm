package utils;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.support.AnnotationConsumer;

import java.lang.annotation.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayArgumentsProvider implements ArgumentsProvider, AnnotationConsumer<ArrayArgumentsProvider.ArraySources> {

    @Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @ArgumentsSource(ArrayArgumentsProvider.class)
    public @interface ArraySources {
        ArraySource[] arrays();
    }

    @Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ArraySource {
        int[] array() default {};
    }

    private List<int[]> arguments;

    public void accept(ArraySources source) {
        List<ArraySource> arrays = Arrays.asList(source.arrays());

        this.arguments = arrays.stream().map(ArraySource::array).collect(Collectors.toList());
    }

    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return this.arguments.stream().map(Arguments::of);
    }
}
