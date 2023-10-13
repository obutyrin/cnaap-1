package com.demo.profile.MadeInWroclaw.controller;

import com.demo.profile.MadeInWroclaw.IMadeinwroclawService;
import com.demo.profile.MadeInWroclaw.model.*;
import com.gringotts.foundation.core.utils.validation.CreateGroup;
import com.gringotts.foundation.core.utils.validation.UpdateGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/** */
@RestController
@Api("swagger-petstore")
@RequiredArgsConstructor
public class MadeinwroclawServiceController implements IMadeinwroclawServiceController {

  private final IMadeinwroclawService madeinwroclawService;

  /** */
  @Override
  public ResponseEntity<Void> addPet(
      @ApiParam(value = "Pet object that needs to be added to the store", required = true)
          @Validated({CreateGroup.class})
          @RequestBody
          Pet body) {

    madeinwroclawService.addPet(body);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /** */
  @Override
  public ResponseEntity<Void> updatePet(
      @ApiParam(value = "Pet object that needs to be added to the store", required = true)
          @Validated({UpdateGroup.class})
          @RequestBody
          Pet body) {

    madeinwroclawService.updatePet(body);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /** */
  @Override
  public ResponseEntity<List<Pet>> findPetsByStatus(
      @ApiParam(value = "Status values that need to be considered for filter", required = true)
          @RequestParam(value = "status", required = true)
          List<String> status) {

    List<Pet> data = madeinwroclawService.findPetsByStatus();
    if (data != null) {
      return new ResponseEntity<>(data, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  /** */
  @Override
  public ResponseEntity<List<Pet>> findPetsByTags(
      @ApiParam(value = "Tags to filter by", required = true)
          @RequestParam(value = "tags", required = true)
          List<String> tags) {

    List<Pet> data = madeinwroclawService.findPetsByTags();
    if (data != null) {
      return new ResponseEntity<>(data, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  /** */
  @Override
  public ResponseEntity<Pet> getPetById(
      @ApiParam(value = "ID of pet to return", required = true)
          @PathVariable(value = "petId", required = true)
          Long petId) {

    Pet data = madeinwroclawService.getPetById(petId);
    if (data != null) {
      return new ResponseEntity<>(data, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  /** */
  @Override
  public ResponseEntity<Void> updatePetWithForm(
      @ApiParam(value = "ID of pet that needs to be updated", required = true)
          @PathVariable(value = "petId", required = true)
          Long petId,
      @ApiParam(value = "Updated name of the pet", required = false) String name,
      @ApiParam(value = "Updated status of the pet", required = false) String status) {

    madeinwroclawService.updatePetWithForm(petId, name, status);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /** */
  @Override
  public ResponseEntity<Void> deletePet(
      @RequestHeader(value = "api_key", required = false) String api_key,
      @ApiParam(value = "Pet id to delete", required = true)
          @PathVariable(value = "petId", required = true)
          Long petId) {

    madeinwroclawService.deletePet(petId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /** */
  @Override
  public ResponseEntity<ModelApiResponse> uploadFile(
      @ApiParam(value = "ID of pet to update", required = true)
          @PathVariable(value = "petId", required = true)
          Long petId,
      @ApiParam(value = "Additional data to pass to server", required = false)
          String additionalMetadata,
      @ApiParam(value = "file to upload", required = false) MultipartFile file) {

    ModelApiResponse data = madeinwroclawService.uploadFile(petId, additionalMetadata, file);
    if (data != null) {
      return new ResponseEntity<>(data, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  /** */
  @Override
  public ResponseEntity<Object> getInventory() {

    Object data = madeinwroclawService.getInventory();
    if (data != null) {
      return new ResponseEntity<>(data, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  /** */
  @Override
  public ResponseEntity<Order> placeOrder(
      @ApiParam(value = "order placed for purchasing the pet", required = true)
          @Validated({CreateGroup.class})
          @RequestBody
          Order body) {

    Order data = madeinwroclawService.placeOrder(body);
    if (data != null) {
      return new ResponseEntity<>(data, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  /** */
  @Override
  public ResponseEntity<Order> getOrderById(
      @ApiParam(value = "ID of pet that needs to be fetched", required = true)
          @PathVariable(value = "orderId", required = true)
          Long orderId) {

    Order data = madeinwroclawService.getOrderById(orderId);
    if (data != null) {
      return new ResponseEntity<>(data, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  /** */
  @Override
  public ResponseEntity<Void> deleteOrder(
      @ApiParam(value = "ID of the order that needs to be deleted", required = true)
          @PathVariable(value = "orderId", required = true)
          Long orderId) {

    madeinwroclawService.deleteOrder(orderId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /** */
  @Override
  public ResponseEntity<Void> createUser(
      @ApiParam(value = "Created user object", required = true)
          @Validated({CreateGroup.class})
          @RequestBody
          User body) {

    madeinwroclawService.createUser(body);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /** */
  @Override
  public ResponseEntity<Void> createUsersWithArrayInput(
      @ApiParam(value = "List of user object", required = true)
          @Validated({CreateGroup.class})
          @RequestBody
          List<User> body) {

    madeinwroclawService.createUsersWithArrayInput(body);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /** */
  @Override
  public ResponseEntity<Void> createUsersWithListInput(
      @ApiParam(value = "List of user object", required = true)
          @Validated({CreateGroup.class})
          @RequestBody
          List<User> body) {

    madeinwroclawService.createUsersWithListInput(body);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /** */
  @Override
  public ResponseEntity<String> loginUser(
      @ApiParam(value = "The user name for login", required = true)
          @RequestParam(value = "username", required = true)
          String username,
      @ApiParam(value = "The password for login in clear text", required = true)
          @RequestParam(value = "password", required = true)
          String password) {

    String data = madeinwroclawService.loginUser();
    if (data != null) {
      return new ResponseEntity<>(data, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  /** */
  @Override
  public ResponseEntity<Void> logoutUser() {

    madeinwroclawService.logoutUser();
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /** */
  @Override
  public ResponseEntity<User> getUserByName(
      @ApiParam(
              value = "The name that needs to be fetched. Use user1 for testing. ",
              required = true)
          @PathVariable(value = "username", required = true)
          String username) {

    User data = madeinwroclawService.getUserByName(username);
    if (data != null) {
      return new ResponseEntity<>(data, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  /** */
  @Override
  public ResponseEntity<Void> updateUser(
      @ApiParam(value = "name that need to be updated", required = true)
          @PathVariable(value = "username", required = true)
          String username,
      @ApiParam(value = "Updated user object", required = true)
          @Validated({UpdateGroup.class})
          @RequestBody
          User body) {

    madeinwroclawService.updateUser(username, body);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /** */
  @Override
  public ResponseEntity<Void> deleteUser(
      @ApiParam(value = "The name that needs to be deleted", required = true)
          @PathVariable(value = "username", required = true)
          String username) {

    madeinwroclawService.deleteUser(username);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
