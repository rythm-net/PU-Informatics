describe('As an API user I wish to have endpoints for accessing general and specific data related blog posts', () => {

  it('can get all posts in the API', () => {

    cy.request(`/posts`).then((response) => {

    console.log(response)

      expect(response.status).to.eq(200);
      assert.equal(response.status, 200);
      assert.equal(response.body.length, 100);

      const experimentalObject = response.body[0];

      assert.isDefined(experimentalObject.id)
      assert.isDefined(experimentalObject.userId)
      assert.isDefined(experimentalObject.title)
      assert.isDefined(experimentalObject.body)
    })
  })

  it('can get specific post with id 1', () => {

    cy.request(`/posts/1`).then((response) => {

      assert.equal(response.status, 200);
      assert.isUndefined(response.body.length);

      assert.isDefined(response.body.id)
      assert.isDefined(response.body.userId)
      assert.isDefined(response.body.title)
      assert.isDefined(response.body.body)
    });
  })

  it('can chain from all to specific post', () => {

    cy.request('/posts')
    .then((response) => {
      const referenceObjectId = response.body[0].id;
      return referenceObjectId;
    })
    .then((postId) => {
      cy.request(`/todos/${postId}`).then((response) => {
          assert.equal(response.status, 200);
      })
    })


  })

})