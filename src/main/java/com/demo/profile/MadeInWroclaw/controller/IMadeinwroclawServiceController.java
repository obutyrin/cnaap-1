package com.demo.profile.MadeInWroclaw.controller;

import com.demo.profile.MadeInWroclaw.model.*;
import com.gringotts.foundation.core.utils.validation.CreateGroup;
import com.gringotts.foundation.core.utils.validation.UpdateGroup;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * This class is generated with methods, which are linked to the swagger file provided during code
 * generation.
 *
 * <p>This file should not be altered as regeneration of code will overwrite this file.
 */
public interface IMadeinwroclawServiceController {

  /** */
  @PostMapping(
      value = "/pet",
      consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Add a new pet to the store",
      tags = {"pet"},
      response = Void.class)
  @ApiResponses({@ApiResponse(code = 405, message = "Invalid input")})
  public ResponseEntity<Void> addPet(
      @ApiParam(value = "Pet object that needs to be added to the store", required = true)
          @Validated({CreateGroup.class})
          @RequestBody
          Pet body);
  /** */
  @PutMapping(
      value = "/pet",
      consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Update an existing pet",
      tags = {"pet"},
      response = Void.class)
  @ApiResponses({
    @ApiResponse(code = 400, message = "Invalid ID supplied"),
    @ApiResponse(code = 404, message = "Pet not found"),
    @ApiResponse(code = 405, message = "Validation exception")
  })
  public ResponseEntity<Void> updatePet(
      @ApiParam(value = "Pet object that needs to be added to the store", required = true)
          @Validated({UpdateGroup.class})
          @RequestBody
          Pet body);
  /** */
  @GetMapping(
      value = "/pet/findByStatus",
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Finds Pets by status",
      tags = {"pet"},
      response = Pet.class)
  @ApiResponses({
    @ApiResponse(code = 200, message = "successful operation"),
    @ApiResponse(code = 400, message = "Invalid status value")
  })
  public ResponseEntity<List<Pet>> findPetsByStatus(
      @ApiParam(value = "Status values that need to be considered for filter", required = true)
          @RequestParam(value = "status", required = true)
          List<String> status);
  /** */
  @GetMapping(
      value = "/pet/findByTags",
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Finds Pets by tags",
      tags = {"pet"},
      response = Pet.class)
  @ApiResponses({
    @ApiResponse(code = 200, message = "successful operation"),
    @ApiResponse(code = 400, message = "Invalid tag value")
  })
  public ResponseEntity<List<Pet>> findPetsByTags(
      @ApiParam(value = "Tags to filter by", required = true)
          @RequestParam(value = "tags", required = true)
          List<String> tags);
  /** */
  @GetMapping(
      value = "/pet/{petId}",
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Find pet by ID",
      tags = {"pet"},
      response = Pet.class)
  @ApiResponses({
    @ApiResponse(code = 200, message = "successful operation"),
    @ApiResponse(code = 400, message = "Invalid ID supplied"),
    @ApiResponse(code = 404, message = "Pet not found")
  })
  public ResponseEntity<Pet> getPetById(
      @ApiParam(value = "ID of pet to return", required = true)
          @PathVariable(value = "petId", required = true)
          Long petId);
  /** */
  @PostMapping(
      value = "/pet/{petId}",
      consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE},
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Updates a pet in the store with form data",
      tags = {"pet"},
      response = Void.class)
  @ApiResponses({@ApiResponse(code = 405, message = "Invalid input")})
  public ResponseEntity<Void> updatePetWithForm(
      @ApiParam(value = "ID of pet that needs to be updated", required = true)
          @PathVariable(value = "petId", required = true)
          Long petId,
      @ApiParam(value = "Updated name of the pet", required = false) String name,
      @ApiParam(value = "Updated status of the pet", required = false) String status);
  /** */
  @DeleteMapping(
      value = "/pet/{petId}",
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Deletes a pet",
      tags = {"pet"},
      response = Void.class)
  @ApiResponses({
    @ApiResponse(code = 400, message = "Invalid ID supplied"),
    @ApiResponse(code = 404, message = "Pet not found")
  })
  public ResponseEntity<Void> deletePet(
      @RequestHeader(value = "api_key", required = false) String api_key,
      @ApiParam(value = "Pet id to delete", required = true)
          @PathVariable(value = "petId", required = true)
          Long petId);
  /** */
  @PostMapping(
      value = "/pet/{petId}/uploadImage",
      consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "uploads an image",
      tags = {"pet"},
      response = ApiResponse.class)
  @ApiResponses({@ApiResponse(code = 200, message = "successful operation")})
  public ResponseEntity<ModelApiResponse> uploadFile(
      @ApiParam(value = "ID of pet to update", required = true)
          @PathVariable(value = "petId", required = true)
          Long petId,
      @ApiParam(value = "Additional data to pass to server", required = false)
          String additionalMetadata,
      @ApiParam(value = "file to upload", required = false) MultipartFile file);
  /** */
  @GetMapping(
      value = "/store/inventory",
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Returns pet inventories by status",
      tags = {"store"},
      response = Object.class)
  @ApiResponses({@ApiResponse(code = 200, message = "successful operation")})
  public ResponseEntity<Object> getInventory();

  /** */
  @PostMapping(
      value = "/store/order",
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Place an order for a pet",
      tags = {"store"},
      response = Order.class)
  @ApiResponses({
    @ApiResponse(code = 200, message = "successful operation"),
    @ApiResponse(code = 400, message = "Invalid Order")
  })
  public ResponseEntity<Order> placeOrder(
      @ApiParam(value = "order placed for purchasing the pet", required = true)
          @Validated({CreateGroup.class})
          @RequestBody
          Order body);
  /** */
  @GetMapping(
      value = "/store/order/{orderId}",
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Find purchase order by ID",
      tags = {"store"},
      response = Order.class)
  @ApiResponses({
    @ApiResponse(code = 200, message = "successful operation"),
    @ApiResponse(code = 400, message = "Invalid ID supplied"),
    @ApiResponse(code = 404, message = "Order not found")
  })
  public ResponseEntity<Order> getOrderById(
      @ApiParam(value = "ID of pet that needs to be fetched", required = true)
          @PathVariable(value = "orderId", required = true)
          Long orderId);
  /** */
  @DeleteMapping(
      value = "/store/order/{orderId}",
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Delete purchase order by ID",
      tags = {"store"},
      response = Void.class)
  @ApiResponses({
    @ApiResponse(code = 400, message = "Invalid ID supplied"),
    @ApiResponse(code = 404, message = "Order not found")
  })
  public ResponseEntity<Void> deleteOrder(
      @ApiParam(value = "ID of the order that needs to be deleted", required = true)
          @PathVariable(value = "orderId", required = true)
          Long orderId);
  /** */
  @PostMapping(
      value = "/user",
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Create user",
      tags = {"user"},
      response = Void.class)
  @ApiResponses({@ApiResponse(code = 500, message = "successful operation")})
  public ResponseEntity<Void> createUser(
      @ApiParam(value = "Created user object", required = true)
          @Validated({CreateGroup.class})
          @RequestBody
          User body);
  /** */
  @PostMapping(
      value = "/user/createWithArray",
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Creates list of users with given input array",
      tags = {"user"},
      response = Void.class)
  @ApiResponses({@ApiResponse(code = 500, message = "successful operation")})
  public ResponseEntity<Void> createUsersWithArrayInput(
      @ApiParam(value = "List of user object", required = true)
          @Validated({CreateGroup.class})
          @RequestBody
          List<User> body);
  /** */
  @PostMapping(
      value = "/user/createWithList",
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Creates list of users with given input array",
      tags = {"user"},
      response = Void.class)
  @ApiResponses({@ApiResponse(code = 500, message = "successful operation")})
  public ResponseEntity<Void> createUsersWithListInput(
      @ApiParam(value = "List of user object", required = true)
          @Validated({CreateGroup.class})
          @RequestBody
          List<User> body);
  /** */
  @GetMapping(
      value = "/user/login",
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Logs user into the system",
      tags = {"user"},
      response = String.class)
  @ApiResponses({
    @ApiResponse(code = 200, message = "successful operation"),
    @ApiResponse(code = 400, message = "Invalid username/password supplied")
  })
  public ResponseEntity<String> loginUser(
      @ApiParam(value = "The user name for login", required = true)
          @RequestParam(value = "username", required = true)
          String username,
      @ApiParam(value = "The password for login in clear text", required = true)
          @RequestParam(value = "password", required = true)
          String password);
  /** */
  @GetMapping(
      value = "/user/logout",
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Logs out current logged in user session",
      tags = {"user"},
      response = Void.class)
  @ApiResponses({@ApiResponse(code = 500, message = "successful operation")})
  public ResponseEntity<Void> logoutUser();
  /** */
  @GetMapping(
      value = "/user/{username}",
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Get user by user name",
      tags = {"user"},
      response = User.class)
  @ApiResponses({
    @ApiResponse(code = 200, message = "successful operation"),
    @ApiResponse(code = 400, message = "Invalid username supplied"),
    @ApiResponse(code = 404, message = "User not found")
  })
  public ResponseEntity<User> getUserByName(
      @ApiParam(
              value = "The name that needs to be fetched. Use user1 for testing. ",
              required = true)
          @PathVariable(value = "username", required = true)
          String username);
  /** */
  @PutMapping(
      value = "/user/{username}",
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Updated user",
      tags = {"user"},
      response = Void.class)
  @ApiResponses({
    @ApiResponse(code = 400, message = "Invalid user supplied"),
    @ApiResponse(code = 404, message = "User not found")
  })
  public ResponseEntity<Void> updateUser(
      @ApiParam(value = "name that need to be updated", required = true)
          @PathVariable(value = "username", required = true)
          String username,
      @ApiParam(value = "Updated user object", required = true)
          @Validated({UpdateGroup.class})
          @RequestBody
          User body);
  /** */
  @DeleteMapping(
      value = "/user/{username}",
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Delete user",
      tags = {"user"},
      response = Void.class)
  @ApiResponses({
    @ApiResponse(code = 400, message = "Invalid username supplied"),
    @ApiResponse(code = 404, message = "User not found")
  })
  public ResponseEntity<Void> deleteUser(
      @ApiParam(value = "The name that needs to be deleted", required = true)
          @PathVariable(value = "username", required = true)
          String username);
}
