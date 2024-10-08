package hr.uniri.molapi.utils;

import hr.uniri.molapi.model.Mol;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ExecuteMethod {
    public static <T> T execute(Mol mol, Function<Mol, T> function) {
        return function.apply(mol);
    }

    public static <T> T execute(Mol mol, String string, BiFunction<Mol, String, T> function) {
        return function.apply(mol, string);
    }

    public static <T> T execute(Mol mol, Integer integer, BiFunction<Mol, Integer, T> function) {
        return function.apply(mol, integer);
    }

    public static <T> T execute(String s, Function<String, T> function) {
        return function.apply(s);
    }

    public static <T> T execute(String s1, String s2, BiFunction<String, String, T> function) {
        return function.apply(s1, s2);
    }

    public static <T> T execute(String s, Integer integer, BiFunction<String, Integer, T> function) {
        return function.apply(s, integer);
    }

    public static <T> T execute(String param, Boolean bool, BiFunction<String, Boolean, T> function) {
        return function.apply(param, bool);
    }

    public static <T> T execute(Mol mol, Integer radius, String methodName, TriFunction<Mol, Integer, String, T> function) {
        return function.apply(mol, radius, methodName);
    }

    public static <T> T execute(String fp1, String fp2, String methodName, TriFunction<String, String, String, T> function) {
        return function.apply(fp1, fp2, methodName);
    }

}
