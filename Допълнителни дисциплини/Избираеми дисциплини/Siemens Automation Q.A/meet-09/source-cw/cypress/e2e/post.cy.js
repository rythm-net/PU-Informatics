describe("As an API user I wish to create a new post", () => {

    it("creates a new post wuith predefined data", () => {
        
        cy.request('POST', '/posts', {
            "userId": 1,
            "title": "Cypress Post Title",
            "body": "Cypress Post Body"
        }).then(response => {
            console.log(response);

            assert.equal(response.status, 201);
            assert.equal(response.body.id, 101);

            assert.isDefined(response.body.title);
            assert.isDefined(response.body.body);

            assert.equal(response.body.title, "Cypress Post Title");
            assert.equal(response.body.body, "Cypress Post Body");
        });
    });
})