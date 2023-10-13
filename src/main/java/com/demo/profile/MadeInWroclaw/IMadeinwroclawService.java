package com.demo.profile.MadeInWroclaw;

import com.demo.profile.MadeInWroclaw.model.*;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/** */
public interface IMadeinwroclawService {

  public void addPet(Pet body);

  public void updatePet(Pet body);

  public List<Pet> findPetsByStatus();

  public List<Pet> findPetsByTags();

  public Pet getPetById(Long petId);

  public void updatePetWithForm(Long petId, String name, String status);

  public void deletePet(Long petId);

  public ModelApiResponse uploadFile(Long petId, String additionalMetadata, MultipartFile file);

  public Object getInventory();

  public Order placeOrder(Order body);

  public Order getOrderById(Long orderId);

  public void deleteOrder(Long orderId);

  public void createUser(User body);

  public void createUsersWithArrayInput(List<User> body);

  public void createUsersWithListInput(List<User> body);

  public String loginUser();

  public void logoutUser();

  public User getUserByName(String username);

  public void updateUser(String username, User body);

  public void deleteUser(String username);
}
