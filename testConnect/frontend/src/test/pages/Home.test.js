import Home from "../../pages/Home";
import { render } from "@testing-library/react";
import renderer from "react-test-renderer";


describe('API 테스트', () => {
    test("GET 조회 시 200 반환", async () => {
        const res = await application.get("/home");
    })
})