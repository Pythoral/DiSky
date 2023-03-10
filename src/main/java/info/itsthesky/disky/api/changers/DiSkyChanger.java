package info.itsthesky.disky.api.changers;

import ch.njol.skript.classes.Changer;
import info.itsthesky.disky.core.Bot;
import info.itsthesky.disky.elements.changers.EffChange;
import org.jetbrains.annotations.NotNull;

public abstract class DiSkyChanger<T> implements Changer<T> {

    @Override
    public final void change(T @NotNull [] what, Object @NotNull [] delta, @NotNull ChangeMode mode) {
        if (EffChange.currentBot != null)
            change(what, delta, EffChange.currentBot, mode);
    }

    public abstract void change(T[] what, Object[] delta, Bot bot, ChangeMode mode);

}