package com.byabie.rdf.lib;

import java.lang.annotation.*;

public class Mixin {
	public class MixinException extends Exception {
		public MixinException(String error) {
			super(error);
		}
	}
	public class RMixinException extends RuntimeException {
		public RMixinException(String error) {
			super(error);
		}
	}
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Inject{}

	@FunctionalInterface
	public interface IBlock<R> {
		R exec(Object... params);
	}
}