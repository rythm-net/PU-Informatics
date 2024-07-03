import "./App.css";
import React from "react";
import { useState } from "react";
import SeedList from "./seed";

/* eslint-disable no-param-reassign, operator-assignment */

/* eslint-disable no-param-reassign, operator-assignment */

function ProductList() {
  const [products, setProducts] = useState(
    SeedList.sort((a, b) => b.votes - a.votes)
  );

  // Inside `ProductList`
  function handleProductUpVote(productId) {
    const nextProducts = products.map((product) => {
      if (product.id === productId) {
        return Object.assign({}, product, {
          votes: product.votes + 1,
        });
      } else {
        return product;
      }
    });
    setProducts(nextProducts);
  }

  //setProducts(products.sort((a, b) => b.votes - a.votes));

  return (
    <div className="ui unstackable items">
      {products.map((product) => (
        <Product
          key={"product-" + product.id}
          id={product.id}
          title={product.title}
          description={product.description}
          url={product.url}
          votes={product.votes}
          submitterAvatarUrl={product.submitterAvatarUrl}
          productImageUrl={product.productImageUrl}
          onVote={handleProductUpVote}
        />
      ))}
    </div>
  );
}

function Product({
  id,
  title,
  description,
  url,
  votes,
  submitterAvatarUrl,
  productImageUrl,
  onVote,
}) {
  function handleUpVote() {
    onVote(id);
  }

  return (
    <div className="item">
      <div className="image">
        <img src={productImageUrl} />
      </div>
      <div className="middle aligned content">
        <div className="header">
          <a onClick={handleUpVote}>
            <i className="large caret up icon" />
          </a>
          {votes}
        </div>
        <div className="description">
          <a href={url}>{title}</a>
          <p>{description}</p>
        </div>
        <div className="extra">
          <span>Submitted by:</span>
          <img className="ui avatar image" src={submitterAvatarUrl} />
        </div>
      </div>
    </div>

    // <div className="item">
    //   <div className="image">
    //     <img src="images/products/image-aqua.png" />
    //   </div>
    //   <div className="middle aligned content">
    //     <div className="description">
    //       <a>Fort Knight</a>
    //       <p>Authentic renaissance actors, delivered in just two weeks.</p>
    //     </div>
    //     <div className="extra">
    //       <span>Submitted by:</span>
    //       <img className="ui avatar image" src="images/avatars/daniel.jpg" />
    //     </div>
    //   </div>
    // </div>
  );
}

export default ProductList;
