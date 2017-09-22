package org.carrito.permission;


import org.carrito.utils.GenericService;
import org.carrito.utils.ServicePath;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ServicePath.PERMISSION_PATH)
public class PermissionService extends GenericService<PermissionEntity, Long> {

}
