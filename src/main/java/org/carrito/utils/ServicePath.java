package org.carrito.utils;

public final class ServicePath {
	
///////////////////////////////////////////////////////////////
// ROOT PATH
///////////////////////////////////////////////////////////////

public static final String ALL = "/**";

public static final String ROOT_PATH = "/api";

public static final String PUBLIC_ROOT_PATH = ROOT_PATH + "/public";
public static final String PRIVATE_ROOT_PATH = ROOT_PATH + "/private";


///////////////////////////////////////////////////////////////
// PUBLIC PATHS
///////////////////////////////////////////////////////////////


public static final String USER_PATH = PRIVATE_ROOT_PATH + "/user";

public static final String PERMISSION_PATH = PRIVATE_ROOT_PATH + "/permission";

public static final String LISTAR_PATH = PRIVATE_ROOT_PATH + "/lista";

public static final String CART_PATH = PRIVATE_ROOT_PATH + "/carrrito";




public static final String LOGIN_PATH = PUBLIC_ROOT_PATH + "/login";

public static final String LOGOUT_PATH = PUBLIC_ROOT_PATH + "/logout";




}
