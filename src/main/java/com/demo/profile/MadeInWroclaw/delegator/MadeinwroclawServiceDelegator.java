package com.demo.profile.MadeInWroclaw.delegator;

import com.demo.profile.MadeInWroclaw.IMadeinwroclawService;
import com.demo.profile.MadeInWroclaw.helper.IMadeinwroclawServiceHelper;
import com.demo.profile.MadeInWroclaw.model.ModelApiResponse;
import com.demo.profile.MadeInWroclaw.model.Order;
import com.demo.profile.MadeInWroclaw.model.Pet;
import com.demo.profile.MadeInWroclaw.model.User;
import com.gringotts.foundation.core.utils.execution.ServiceExecutionContextUtil;
import com.gringotts.foundation.core.utils.future.FutureUtils;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@RequiredArgsConstructor
public class MadeinwroclawServiceDelegator
    implements IMadeinwroclawService, ServiceExecutionContextUtil {
  private final FutureUtils futureUtils;

  private final IMadeinwroclawServiceHelper madeinwroclawServiceHelper;

  @Override
  public void addPet(Pet body) {
    madeinwroclawServiceHelper.processAddPetRequest();
    madeinwroclawServiceHelper.processAddPetResponse();
  }

  @Override
  public void updatePet(Pet body) {
    madeinwroclawServiceHelper.processUpdatePetRequest();
    madeinwroclawServiceHelper.processUpdatePetResponse();
  }

  @Override
  public List<Pet> findPetsByStatus() {
    madeinwroclawServiceHelper.processFindPetsByStatusRequest();
    return madeinwroclawServiceHelper.processFindPetsByStatusResponse();
  }

  @Override
  public List<Pet> findPetsByTags() {
    madeinwroclawServiceHelper.processFindPetsByTagsRequest();
    return madeinwroclawServiceHelper.processFindPetsByTagsResponse();
  }

  @Override
  public Pet getPetById(Long petId) {
    madeinwroclawServiceHelper.processGetPetByIdRequest();
    return madeinwroclawServiceHelper.processGetPetByIdResponse();
  }

  @Override
  public void updatePetWithForm(Long petId, String name, String status) {
    madeinwroclawServiceHelper.processUpdatePetWithFormRequest();
    madeinwroclawServiceHelper.processUpdatePetWithFormResponse();
  }

  @Override
  public void deletePet(Long petId) {
    madeinwroclawServiceHelper.processDeletePetRequest();
    madeinwroclawServiceHelper.processDeletePetResponse();
  }

  @Override
  public ModelApiResponse uploadFile(Long petId, String additionalMetadata, MultipartFile file) {
    madeinwroclawServiceHelper.processUploadFileRequest();
    return madeinwroclawServiceHelper.processUploadFileResponse();
  }

  @Override
  public Object getInventory() {
    madeinwroclawServiceHelper.processGetInventoryRequest();
    return madeinwroclawServiceHelper.processGetInventoryResponse();
  }

  @Override
  public Order placeOrder(Order body) {
    madeinwroclawServiceHelper.processPlaceOrderRequest();
    return madeinwroclawServiceHelper.processPlaceOrderResponse();
  }

  @Override
  public Order getOrderById(Long orderId) {
    madeinwroclawServiceHelper.processGetOrderByIdRequest();
    return madeinwroclawServiceHelper.processGetOrderByIdResponse();
  }

  @Override
  public void deleteOrder(Long orderId) {
    madeinwroclawServiceHelper.processDeleteOrderRequest();
    madeinwroclawServiceHelper.processDeleteOrderResponse();
  }

  @Override
  public void createUser(User body) {
    madeinwroclawServiceHelper.processCreateUserRequest();
    madeinwroclawServiceHelper.processCreateUserResponse();
  }

  @Override
  public void createUsersWithArrayInput(List<User> body) {
    madeinwroclawServiceHelper.processCreateUsersWithArrayInputRequest();
    madeinwroclawServiceHelper.processCreateUsersWithArrayInputResponse();
  }

  @Override
  public void createUsersWithListInput(List<User> body) {
    madeinwroclawServiceHelper.processCreateUsersWithListInputRequest();
    madeinwroclawServiceHelper.processCreateUsersWithListInputResponse();
  }

  @Override
  public String loginUser() {
    madeinwroclawServiceHelper.processLoginUserRequest();
    return madeinwroclawServiceHelper.processLoginUserResponse();
  }

  @Override
  public void logoutUser() {
    madeinwroclawServiceHelper.processLogoutUserRequest();
    madeinwroclawServiceHelper.processLogoutUserResponse();
  }

  @Override
  public User getUserByName(String username) {
    madeinwroclawServiceHelper.processGetUserByNameRequest();
    return madeinwroclawServiceHelper.processGetUserByNameResponse();
  }

  @Override
  public void updateUser(String username, User body) {
    madeinwroclawServiceHelper.processUpdateUserRequest();
    madeinwroclawServiceHelper.processUpdateUserResponse();
  }

  @Override
  public void deleteUser(String username) {
    madeinwroclawServiceHelper.processDeleteUserRequest();
    madeinwroclawServiceHelper.processDeleteUserResponse();
  }
}
