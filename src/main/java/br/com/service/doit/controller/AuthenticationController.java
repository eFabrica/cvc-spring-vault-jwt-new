package br.com.service.doit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.service.doit.config.TokenProvider;
import br.com.service.doit.model.AuthToken;
import br.com.service.doit.model.LoginUser;
import br.com.service.doit.model.UserDto;
import br.com.service.doit.model.Users;
import br.com.service.doit.service.UserService;
import br.com.service.doit.util.Constants;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/v1/users")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenProvider jwtTokenUtil;

	@Autowired
	private UserService userService;

	@Value("${cvc.url.elk}")
	private String elkUrl;

	@Value("${cvc.url.vault}")
	private String vaultUrl;

	@ApiOperation(value = "Autenticação de usuários", authorizations = { @Authorization(value = "OAuth2") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = Constants.HTTP_400),
			@ApiResponse(code = 404, message = Constants.HTTP_404),
			@ApiResponse(code = 401, message = Constants.HTTP_401),
			@ApiResponse(code = 403, message = Constants.HTTP_403),
			@ApiResponse(code = 500, message = Constants.HTTP_500) })
	@PostMapping("/authenticate")
	public ResponseEntity<AuthToken> generateToken(@RequestBody LoginUser loginUser) throws AuthenticationException {

		final Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		final String token = jwtTokenUtil.generateToken(authentication);
		return ResponseEntity.ok(new AuthToken(token));
	}

	@ApiOperation(value = "Registro de usuários", authorizations = { @Authorization(value = "OAuth2") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = Constants.HTTP_400),
			@ApiResponse(code = 404, message = Constants.HTTP_404),
			@ApiResponse(code = 401, message = Constants.HTTP_401),
			@ApiResponse(code = 403, message = Constants.HTTP_403),
			@ApiResponse(code = 500, message = Constants.HTTP_500) })
	@PostMapping("/register")
	public Users saveUser(@RequestBody UserDto user) {
		return userService.save(user);
	}

	@ApiOperation(value = "Acesso aos dados do ELK", authorizations = { @Authorization(value = "OAuth2") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = Constants.HTTP_400),
			@ApiResponse(code = 404, message = Constants.HTTP_404),
			@ApiResponse(code = 401, message = Constants.HTTP_401),
			@ApiResponse(code = 403, message = Constants.HTTP_403),
			@ApiResponse(code = 500, message = Constants.HTTP_500) })
	@GetMapping("/elk")
	public ResponseEntity<String> displayElkUrl() {
		return ResponseEntity.ok(elkUrl);
	}

	@ApiOperation(value = "Acesso ao dados do Vault", authorizations = { @Authorization(value = "OAuth2") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = Constants.HTTP_400),
			@ApiResponse(code = 404, message = Constants.HTTP_404),
			@ApiResponse(code = 401, message = Constants.HTTP_401),
			@ApiResponse(code = 403, message = Constants.HTTP_403),
			@ApiResponse(code = 500, message = Constants.HTTP_500) })
	@GetMapping("/vault")
	public ResponseEntity<String> displayVaultUrl() {
		return ResponseEntity.ok(vaultUrl);
	}
	
	@GetMapping("/adminping")
	public String adminPing() {
		return "SOMENTE O 'ADMIN' PODE LER ISSO";
	}

	@GetMapping("/managerping")
	public String managerPing() {
		return "SOMENTE O 'ADMIN' E O 'MANAGER' PODE LER ISSO";
	}

	@GetMapping("/sellerping")
	public String sellerPing() {
		return "SOMENTE O 'ADMIN', 'MANAGER' E 'SELLER' PODE LER ISSO";
	}

	@GetMapping("/userping")
	public String userPing() {
		return "QUALQUER USUARIOS PODE LER ISSO";
	}

}
