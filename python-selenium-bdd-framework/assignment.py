def assignment():
    """
    This function is a placeholder for the assignment logic.
    It can be implemented to perform specific tasks as required.
    """
    driver = webdriver.Chrome()
    driver.get("https://www.saucedemo.com/")
    driver.find_element(By.ID, "user-name").send_keys("standard_user")
    driver.find_element(By.ID, "password").send_keys("secret_sauce")
    driver.find_element(By.ID, "login-button").click()
    
    driver.find_element(By.ID, "add-to-cart-sauce-labs-backpack").click()
    driver.find_element(By.ID, "add-to-cart-sauce-labs-bike-light").click()
    driver.find_element(By.ID, "shopping_cart_container").click()
    
    assert "Sauce Labs Backpack" in driver.page_source
    assert "Sauce Labs Bike Light" in driver.page_source
    
    driver.find_element(By.ID, "checkout").click()
    
    assert "Checkout: Your Information" in driver.page_source
    
    driver.find_element(By.ID, "first-name").send_keys("John")
    driver.find_element(By.ID, "last-name").send_keys("Doe")
    driver.find_element(By.ID, "postal-code").send_keys("12345")
    driver.find_element(By.ID, "continue").click()
    
    
    assert "Sauce Labs Backpack" in driver.page_source
    assert "Sauce Labs Bike Light" in driver.page_source
    
    driver.find_element(By.ID, "Finish").click()
    
    driver.find_element(By.ID, "Logout").click()
    
    