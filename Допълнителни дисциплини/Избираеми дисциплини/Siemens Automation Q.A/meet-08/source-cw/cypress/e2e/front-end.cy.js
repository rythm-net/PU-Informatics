describe('Test basic front-end functionality', () => {

  beforeEach(() => {
    // cy.visit(`https://mihail-petrov.me/`)
  });

  // Да се провери дали името на приложението ми 
  // е коректно. 
  // Като потребител на системата искам да се логна 
  // в https://mihail-petrov.me/
  // и искам да видя на първата страни заглавието на приложението 
  // Mindblown: a blog about philosophy.
  it.only('shows a correct titel of the app on the HOME page', () => {
    cy.visit(`https://mihail-petrov.me/`)
    cy.log("Try to locate specific text")
    // cy.contains("a blogA.")
    cy.get(".alignwide").contains("a blog")
    // const element = cy.get(".alignwide");
    // element.contains("a blog")

    // const element = cy.contains("Sample Page");
    // element.click();

    // cy.contains("Sample Page");
    // cy.click();
  })

  it("locate Sample page and navigate to diferent part of the app", () => {
    // cy.visit(`https://mihail-petrov.me/`);
    // cy.contains("Sample Page").click(); 

    // //*[@id="modal-1-content"]/ul/li/a
    // /html/body/div/header/div/div/nav/div/div/div/div/ul/li/a

    cy.xpath(`//*[@id="modal-1-content"]/ul/li/a`).click();
  })

  it("locates Wordpress link and navigate to the official website", () => {

    cy.xpath(`/html/body/div/footer/div/div/p[2]/a`, {timeout: 5000 }).click();
    cy.wait(5000)

    cy.origin(`https://wordpress.org/`, () => {
      cy.contains("WordPress:");
    });
  })

  it("create a new duplicated comment", () => {
    cy.get("h2").click();
    cy.get("h1").contains("Hello world!")
    cy.get("#comment").type(`Sample comment`)
    cy.get("#author").type(`Mihail Petrov`)
    cy.get("#email").type(`mail@mihail-petrov.me`)
    cy.get("#submit").click();
    cy.get(".wp-die-message").contains("Duplicate comment detected; it looks as though you’ve already said that!");
  });

  it("create a new comment on already existng post", () => {
    cy.get("h2").click();
    cy.get("h1").contains("Hello world!")
    cy.get("#comment").type(`Sample comment ${Date.now()}`)
    cy.wait(4000)
    cy.get("#author").type(`Mihail Petrov`)
    cy.wait(4000)
    cy.get("#email").type(`mail@mihail-petrov.me`)
    cy.wait(4000)
    cy.get("#submit").click();
    cy.get(".comment-awaiting-moderation")
  });

})