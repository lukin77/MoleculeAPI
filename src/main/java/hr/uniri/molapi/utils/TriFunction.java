package hr.uniri.molapi.utils;

@FunctionalInterface
public interface TriFunction<T, U, B, R> {
    R apply(T t, U u, B b);
}
