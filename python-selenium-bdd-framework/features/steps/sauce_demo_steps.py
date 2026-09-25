from behave import given, then, when

from pages.cart_page import CartPage
from pages.checkout_page import CheckoutPage
from pages.inventory_page import InventoryPage
from pages.login_page import LoginPage


@given("I am on the Sauce Demo login page")
def step_open_login_page(context):
    context.login_page = LoginPage(context.driver)
    context.login_page.open(context.base_url)


@when('I log in with username "{username}" and password "{password}"')
def step_login(context, username, password):
    context.login_page.login(username, password)
    if context.login_page.is_error_displayed(timeout=1):
        return
    context.inventory_page = InventoryPage(context.driver)
    context.inventory_page.wait_until_loaded()


@then("I should see the Sauce Demo inventory page")
def step_verify_inventory_page(context):
    assert context.inventory_page.is_open(), (
        f"Expected inventory page, got {context.driver.current_url}"
    )
    
@then('I should see an error message "{message}"')
def step_verify_error_message(context, message):
    assert context.login_page.is_error_displayed(), (
        f"Expected error message {message!r}, got {context.driver.current_url}"
    )
    assert context.login_page.error_message() == message

@when('I add the "{product_name}" product to the cart')
def step_add_product(context, product_name):
    context.inventory_page.add_product_to_cart(product_name)
    context.inventory_page.open_cart()
    context.cart_page = CartPage(context.driver)

@then('the cart should contain "{product_name}"')
def step_verify_product_in_cart(context, product_name):
    assert context.cart_page.contains_product(product_name), (
        f"Expected {product_name!r} to be present in the cart"
    )

@when("I start checkout")
def step_start_checkout(context):
    context.cart_page.proceed_to_checkout()
    context.checkout_page = CheckoutPage(context.driver)


@when('I enter checkout information first name "{first_name}", last name "{last_name}", and postal code "{postal_code}"')
def step_enter_checkout_information(context, first_name, last_name, postal_code):
    context.checkout_page.enter_customer_information(first_name, last_name, postal_code)


@when("I place the order")
def step_place_order(context):
    context.checkout_page.place_order()


@then('I should see the checkout confirmation "{expected_message}"')
def step_verify_checkout_confirmation(context, expected_message):
    assert context.checkout_page.confirmation_message() == expected_message
