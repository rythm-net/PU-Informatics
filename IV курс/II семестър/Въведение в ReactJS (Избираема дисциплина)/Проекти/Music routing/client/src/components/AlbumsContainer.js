import React, { Component, useState } from "react";

import { Routes, Route, useParams, useLocation } from "react-router-dom";

import Album from "./Album";
import VerticalMenu from "./VerticalMenu";
import { client } from "../Client";
import { useEffect } from "react";
import usePath from "../user-path";

const ALBUM_IDS = [
  "23O4F21GDWiGd33tFN3ZgI",
  "3AQgdwMNCiN7awXch5fAaG",
  "1kmyirVya5fRxdjsPFDM05",
  "6ymZBbRSmzAvoSGmwAFoxm",
  "4Mw9Gcu1LT7JaipXdwrq1Q",
];

function AlbumsContainer({ props }) {
  const [fetched, setFetched] = useState(false);
  const [albums, setAlbums] = useState([]);

  useEffect(() => {
    getAlbums();
  }, []);

  let getAlbums = () => {
    client.getAlbums(ALBUM_IDS).then((albums) => {
      setFetched(true);
      setAlbums(albums);
    });
  };

  let getPosition = (string, subString, index) => {
    return string.split(subString, index).join(subString).length;
  };

  if (!fetched) {
    return <div className="ui active centered inline loader" />;
  } else {
    const matchPath = "/albums"; //path[0];

    return (
      <div className="ui two column divided grid">
        <div className="ui six wide column" style={{ maxWidth: 250 }}>
          <VerticalMenu albums={albums} albumsPathname={matchPath} />
        </div>
        <div className="ui ten wide column">
          {
            <Routes>
              <Route
                exact
                path={""}
                element={<SearchAlbum />}
                // render={() => (
                //   <div>
                //     <h3>Please select an album on the left</h3>
                //   </div>
                // )}
              />
              <Route
                path={":albumId"}
                element={<AlbumRender albums={albums} matchPath={matchPath} />}
                // render={({ match }) => {
                //   const album = albums.find(
                //     (a) => a.id === match.params.albumId
                //   );
                //   return <Album album={album} albumsPathname={matchPath} />;
                // }}
              />
            </Routes>
          }
        </div>
      </div>
    );
  }
}

const SearchAlbum = () => (
  <div>
    <h3>Please select an album on the left</h3>
  </div>
);

function AlbumRender({ albums, matchPath }) {
  let param = useParams();
  const album = albums.find((a) => a.id === param.albumId);
  return <Album album={album} albumsPathname={matchPath} />;
}

export default AlbumsContainer;
