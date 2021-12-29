package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepDefs {
    HomePage homepage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationSuccessPage registrationSuccessPage = new RegistrationSuccessPage();

    ComputersPage computersPage = new ComputersPage();
    DesktopPage desktopPage = new DesktopPage();
    BuildYourOwnComputerPage buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    ProductEmailAFriendPage productEmailAFriendPage = new ProductEmailAFriendPage();

    NewReleasePage newReleasePage = new NewReleasePage();

    CategoryUrl categoryUrl = new CategoryUrl();
    Footer footer = new Footer();
    Cart cart = new Cart();
    CheckOutPage checkOutPage = new CheckOutPage();

    @Given("user is on registration page")
    public void user_is_on_registration_page() {
        homepage.clickOnRegisterLink();
    }

    @When("user enters required registration details")
    public void user_enters_required_registration_details() {
        registrationPage.fillUserDetails();
    }

    @When("click on register submit button")
    public void click_on_register_submit_button() {
        registrationPage.clickOnRegisterButton();
    }

    @Then("user should able to register successfully")
    public void user_should_able_to_register_successfully() {
        registrationSuccessPage.verifyUserIsOnRegisterSuccessPage();
        registrationSuccessPage.verifyUserHasSuccessfullyRegistered();
    }

    @Given("user clicks on computers main menu")
    public void user_clicks_on_computers_main_menu() {
        homepage.clickOnComputersMenu();
    }

    @Given("user clicks on desktop heading")
    public void user_clicks_on_desktop_heading() {
        computersPage.clickOnDesktopsHeading();
    }

    @Then("user should see desktop page")
    public void user_should_see_desktop_page() {
        desktopPage.checkUserIsInTheDesktopPage();
    }

    @Then("user clicks on Build your own computer heading")
    public void user_clicks_on_build_your_own_computer_heading() {
        desktopPage.clickOnAProduct();
    }

    @Then("user should see Build your own computer page")
    public void user_should_see_build_your_own_computer_page() {
        buildYourOwnComputerPage.checkUserIsOnThisPage();
    }

    @Then("user clicks on Email a friend button")
    public void user_clicks_on_email_a_friend_button() {
        buildYourOwnComputerPage.clickOnEmailAFriendButton();
    }

    @Then("user should see email a friend page")
    public void user_should_see_email_a_friend_page() {
        productEmailAFriendPage.checkUserIsOnTheProductEmailAFriendPage();
    }

    @When("user fills the form")
    public void user_fills_the_form() {
        productEmailAFriendPage.fillEmailAFriendForm();
    }

    @When("clicks on send email button")
    public void clicks_on_send_email_button() {
        productEmailAFriendPage.clickOnSendEmailButton();
    }

    @Then("user should see the email has been successfully sent message")
    public void user_should_see_the_email_has_been_successfully_sent_message() {
        productEmailAFriendPage.checkEmailIsSentSuccessfully();
    }

    @When("user click on details button")
    public void user_click_on_details_button() {
        homepage.clickOnDetailsButton();
    }

    @When("user fills comments form")
    public void user_fills_comments_form() {
        newReleasePage.checkUserIsInTheNewReleasePage();
        newReleasePage.fillCommentSection();
    }

    @When("clicks on new comment button")
    public void clicks_on_new_comment_button() {
        newReleasePage.clickOnNewCommentButton();
    }

    @Then("the user should see the comment has been posted successfully")
    public void the_user_should_see_the_comment_has_been_posted_successfully() {
        newReleasePage.checkTheCommentIsPostedSuccessfully();
    }

    @Given("User is on homepage")
    public void user_is_on_homepage() {
        homepage.clickOnLogo();
    }

    @When("user clicks on  category {string} in main menu")
    public void user_clicks_on_category_in_main_menu(String category) {
        Utils.clickOnMenuItem(category);
    }

    @Then("verify user is on  url {string} accordingly")
    public void verify_user_is_on_url_accordingly(String pageURL) {
        categoryUrl.verifyUrl(pageURL);
    }

    @Then("verify the title {string} of the page")
    public void verify_the_title_of_the_page(String pageTitle) {
        categoryUrl.verifyPageTitle(pageTitle);
    }

    @When("user clicks on social links {string}")
    public void user_clicks_on_social_links(String social) {
        footer.clickOnSocialIcon(social);
    }

    @Then("user should see relevant social media page url {string}")
    public void userShouldSeeRelevantSocialMediaPageUrl(String socialURL) {
        footer.verifyUserIsOnSocialMediaPage(socialURL);
    }

    @Given("user is already registered")
    public void userIsAlreadyRegistered() {
        homepage.clickOnRegisterLink();
        registrationPage.checkUserIsInRegisterPage();
        registrationPage.fillUserDetails();
        registrationPage.clickOnRegisterButton();
        registrationSuccessPage.verifyUserHasSuccessfullyRegistered();
    }

    @When("user hovers over  category {string} in main menu")
    public void userHoversOverCategoryInMainMenu(String category) {
        categoryUrl.hoverOverMainMenu(category);
    }

    @And("user clicks on submenu {string}")
    public void userClicksOnSubmenu(String subMenu) {
        categoryUrl.clickOnSubMenu(subMenu);
    }

    @When("user select the relevant configuration")
    public void userSelectTheRelevantConfiguration() {
        buildYourOwnComputerPage.selectProcessor();
        buildYourOwnComputerPage.selectRAM();
        buildYourOwnComputerPage.selectHDD();
        buildYourOwnComputerPage.chooseOS();
        buildYourOwnComputerPage.chooseSoftware();

    }

//    @And("user clicks on {string} button")
//    public void userClicksOnButton(String linkText) {
//        Utils.clickOnBtn(linkText);
////        buildYourOwnComputerPage.clickOnAddToCartBtn();
//    }

    @Then("The product should have been added to the cart successfully")
    public void theProductShouldHaveBeenAddedToTheCartSuccessfully() {
        buildYourOwnComputerPage.verifyProductHasBeenAddedSuccessfully();
    }

    @When("user agrees to terms and conditions")
    public void userAgreesToTermsAndConditions() {
        cart.acceptTermsAndConditions();
    }


    @And("user clicks on the check out button")
    public void userClicksOnTheCheckOutButton() {
        cart.clickOnCheckOutBtn();
    }

    @And("user clicks on the add to card button")
    public void userClicksOnTheAddToCardButton() {
        buildYourOwnComputerPage.clickOnAddToCartBtn();
    }

    @When("user clicks on Shopping cart button")
    public void userClicksOnShoppingCartButton() {
        buildYourOwnComputerPage.clickOnShoppingCartBtn();
    }

    @When("user clicks on Checkout button")
    public void userClicksOnCheckoutButton() {
        cart.clickOnCheckOutBtn();
    }

    @Then("user should see the checkout page")
    public void userShouldSeeTheCheckoutPage() {
        checkOutPage.verifyUserIsOnCheckOutPage();
    }

    @When("user fills billing address form")
    public void userFillsBillingAddressForm() {
        checkOutPage.fillBillingAddressForm();
    }


    @And("user fills shipping method form")
    public void userFillsShippingMethodForm() {
        checkOutPage.fillShippingMethodForm();
    }

    @And("user selects credit card as the payment type")
    public void userSelectsCreditCardAsThePaymentType() {
        checkOutPage.selectPaymentType();
    }

    @And("user fills payment information form")
    public void userFillsPaymentInformationForm() {
        checkOutPage.fillPaymentInformation();
    }

    @And("user confirms order")
    public void userConfirmsOrder() {
        checkOutPage.confirmOrder();
    }


    @When("user clicks on vote button")
    public void user_clicks_on_vote_button() {
        homepage.clickOnVoteBtn();
    }
    @Then("an alert should pop asking to choose an option")
    public void an_alert_should_pop_asking_to_choose_an_option() {
        homepage.handleAlertBox();
    }


    @And("user clicks on submenu")
    public void userClicksOnSubmenu() {
    }
}
