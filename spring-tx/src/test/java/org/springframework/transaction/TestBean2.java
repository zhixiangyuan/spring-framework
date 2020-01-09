package org.springframework.transaction;

import org.springframework.tests.sample.beans.TestBean;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhixiang.yuan
 * @since 2020/01/09 07:55:00
 */
public class TestBean2 extends TestBean {
	@Override
	@Transactional
	public Object returnsThis() {
		return super.returnsThis();
	}
}
