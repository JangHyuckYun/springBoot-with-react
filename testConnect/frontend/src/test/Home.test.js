import Home from "./../pages/Home";
import { render } from "@testing-library/react";

it('matches snapshot', function () {
    const utils = render(<Home />)
    expect(utils.container).toMatchSnapshot()
});
