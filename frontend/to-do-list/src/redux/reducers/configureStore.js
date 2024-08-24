import { legacy_createStore as createStore, applyMiddleware, compose } from "redux"; // note that creatStore is deprecated so use toolKit instead in future when using redux
import rootReducer from "../reducers";
import reduxImmutableStateInvariant from "redux-immutable-state-invariant";
import { thunk } from 'redux-thunk';

export default function configureStore(initialState) {
  const composeEnhancers =
    window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose; // add support for Redux dev tools

  return createStore(
    rootReducer,
    initialState,
    composeEnhancers(applyMiddleware(thunk, reduxImmutableStateInvariant())) // added thunk to applyMiddleware which takes multiple middlewares as inputs
  );
}
