package com.demo.profile.MadeInWroclaw.delegator;

import com.demo.profile.MadeInWroclaw.delegator.config.TestConfiguration;
import com.demo.profile.MadeInWroclaw.helper.IMadeinwroclawServiceHelper;
import com.demo.profile.MadeInWroclaw.model.*;
import com.gringotts.foundation.core.utils.execution.ServiceExecutionContextUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class MadeinwroclawServiceTestDelegatorTest implements ServiceExecutionContextUtil {

  @Autowired private IMadeinwroclawServiceHelper madeinwroclawServiceHelper;

  @Test
  public void testAddPet() {
    Assert.assertEquals(true, true);
  }

  @Test
  public void testUpdatePet() {
    Assert.assertEquals(true, true);
  }

  @Test
  public void testFindPetsByStatus() {
    Assert.assertEquals(true, true);
  }

  @Test
  public void testFindPetsByTags() {
    Assert.assertEquals(true, true);
  }

  @Test
  public void testGetPetById() {
    Assert.assertEquals(true, true);
  }

  @Test
  public void testUpdatePetWithForm() {
    Assert.assertEquals(true, true);
  }

  @Test
  public void testDeletePet() {
    Assert.assertEquals(true, true);
  }

  @Test
  public void testUploadFile() {
    Assert.assertEquals(true, true);
  }

  @Test
  public void testGetInventory() {
    Assert.assertEquals(true, true);
  }

  @Test
  public void testPlaceOrder() {
    Assert.assertEquals(true, true);
  }

  @Test
  public void testGetOrderById() {
    Assert.assertEquals(true, true);
  }

  @Test
  public void testDeleteOrder() {
    Assert.assertEquals(true, true);
  }

  @Test
  public void testCreateUser() {
    Assert.assertEquals(true, true);
  }

  @Test
  public void testCreateUsersWithArrayInput() {
    Assert.assertEquals(true, true);
  }

  @Test
  public void testCreateUsersWithListInput() {
    Assert.assertEquals(true, true);
  }

  @Test
  public void testLoginUser() {
    Assert.assertEquals(true, true);
  }

  @Test
  public void testLogoutUser() {
    Assert.assertEquals(true, true);
  }

  @Test
  public void testGetUserByName() {
    Assert.assertEquals(true, true);
  }

  @Test
  public void testUpdateUser() {
    Assert.assertEquals(true, true);
  }

  @Test
  public void testDeleteUser() {
    Assert.assertEquals(true, true);
  }
}
