package hr.uniri.molapi.utils;

import hr.uniri.molapi.model.Mol;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ExecuteMethod {
    public static <T> T execute(Mol mol, Function<Mol, T> function) {
        return function.apply(mol);
    }

    public static <T> T execute(Mol mol, String radius, BiFunction<Mol, String, T> function) {
        return function.apply(mol, radius);
    }

    public static <T> T execute(String s, Function<String, T> function) {
        return function.apply(s);
    }

    public static <T> T execute(String s1, String s2, BiFunction<String, String, T> function) {
        return function.apply(s1, s2);
    }

    public static Boolean execute(String s, Integer integer, BiFunction<String, Integer, Boolean> function) {
        return function.apply(s, integer);
    }

    public static Mol execute(String param, Boolean bool, BiFunction<String, Boolean, Mol> function) {
        return function.apply(param, bool);
    }

}
