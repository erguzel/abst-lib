package com.sicsrobotics.util.exeption.helper;

import com.sicsrobotics.model.mappy.SicsMapEntry;
import com.sicsrobotics.util.exeption.SicsException;

import java.util.function.Consumer;
import java.util.function.Function;

public class ExceptionHelper<T,R> {

    public R TryCatch(Function<T,R> function, T param, SicsException ex){

        R res = null;

        try {
           res = function.apply(param);
        }catch (Throwable e){

            ex.AddTada(new SicsMapEntry<>(function.toString(),param.toString()))
                    .Act(true);

        }

        return res;
    }
}
