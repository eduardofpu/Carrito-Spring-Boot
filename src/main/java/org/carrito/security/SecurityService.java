package org.carrito.security;

import java.security.Principal;

import org.carrito.utils.ServiceMap;
import org.carrito.utils.ServicePath;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ServicePath.LOGIN_PATH)
public class SecurityService implements ServiceMap {

	@RequestMapping(method = { RequestMethod.GET })
	public Principal user(Principal user) {
		return user;
	}

}
