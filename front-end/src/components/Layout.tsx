import React from "react";
import Navigation from "./Navigation";

type LayoutProps = {
  children: any
}

function Layout({ children }: LayoutProps) {
  return (
    <>
      <Navigation/>
      <main>{children}</main>
    </>
  );
}

export default Layout;
