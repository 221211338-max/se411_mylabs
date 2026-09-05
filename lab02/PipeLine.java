public class PipeLine<T, R> {

    private interface Stage<I, O> {
        O apply(I input);
    }

    private static class IdentityStage<I> implements Stage<I, I> {

        @Override
        public I apply(I input) {
            return input;
        }
    }

    private static class NextStage<I, M, O> implements Stage<I, O> {

        private final Stage<I, M> previous;
        private final Transformer<? super M, ? extends O> transformer;

        public NextStage(
                Stage<I, M> previous,
                Transformer<? super M, ? extends O> transformer) {
            this.previous = previous;
            this.transformer = transformer;
        }

        @Override
        public O apply(I input) {
            M previousResult = previous.apply(input);
            return transformer.transform(previousResult);
        }
    }

    private final Stage<T, R> lastStage;

    private PipeLine(Stage<T, R> lastStage) {
        this.lastStage = lastStage;
    }

    public static <T> PipeLine<T, T> start() {
        return new PipeLine<>(new IdentityStage<>());
    }

    public <N> PipeLine<T, N> addTransformer(
            Transformer<? super R, ? extends N> transformer) {

        return new PipeLine<>(
                new NextStage<>(lastStage, transformer));
    }

    public R execute(T input) {
        return lastStage.apply(input);
    }
}