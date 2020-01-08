package org.springframework.core;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author zhixiang.yuan
 * @since 2020/01/08 10:03:44
 */
public class ResolvableType1Test {
	@Test
	public void genericTest() {
		ResolvableType resolvableType = ResolvableType.forClass(GenericRootTestImpl.class);
		ResolvableType as = resolvableType.as(GenericRootTest.class);
		assertThat(as.getGeneric(0).getRawClass()).isEqualTo(String.class);
		assertThat(as.getGeneric(1).getRawClass()).isEqualTo(Integer.class);
	}
}

class GenericRootTest<T, N> {

}

class GenericRootTestImpl extends GenericRootTest<String, Integer> {

}

