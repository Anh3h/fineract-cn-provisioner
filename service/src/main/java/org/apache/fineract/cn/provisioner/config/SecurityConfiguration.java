package org.apache.fineract.cn.provisioner.config;

import java.util.Properties;

import org.apache.fineract.cn.lang.security.RsaKeyPairFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@Profile("production")
public class SecurityConfiguration extends WebMvcConfigurerAdapter {

	private RsaKeyPairFactory.KeyPairHolder keyPairHolder;
	private Properties properties = System.getProperties();

	public SecurityConfiguration() {
		super();
		this.keyPairHolder = RsaKeyPairFactory.createKeyPair();
		this.properties.setProperty("system.publicKey.timestamp", this.keyPairHolder.getTimestamp());
		this.properties.setProperty("system.publicKey.modulus", this.keyPairHolder.publicKey().getModulus().toString());
		this.properties.setProperty("system.publicKey.exponent", this.keyPairHolder.publicKey().getPublicExponent().toString());
		System.out.println("system.publicKey.timestamp : " + this.keyPairHolder.getTimestamp());
		System.out.println("system.publicKey.modulus : "+ this.keyPairHolder.publicKey().getModulus().toString());
		System.out.println("system.publicKey.exponent : "+ this.keyPairHolder.publicKey().getPublicExponent().toString());
		this.properties.setProperty("system.privateKey.modulus", this.keyPairHolder.privateKey().getModulus().toString());
		this.properties.setProperty("system.privateKey.exponent", this.keyPairHolder.privateKey().getPrivateExponent().toString());
		System.getProperties().putAll(this.properties);
	}
}
