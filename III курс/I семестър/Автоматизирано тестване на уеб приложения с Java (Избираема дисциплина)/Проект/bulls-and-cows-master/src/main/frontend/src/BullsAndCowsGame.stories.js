import React from "react";

import BullsAndCowsGame from "./BullsAndCowsGame";

export default {
  title: "BullsAndCowsGame",
  component: BullsAndCowsGame,
};

const Template = (args) => <BullsAndCowsGame {...args} />;

export const Default = Template.bind({});
Default.args = {};
