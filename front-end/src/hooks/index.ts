import {atom, useRecoilState} from "recoil";

interface User {
  name: string,
  username: string,
  jwt: string
}

const userKey = 'user';

const userAtom = atom<User | null>({
  key: userKey,
  // @ts-ignore
  default: JSON.parse(localStorage.getItem(userKey))
});

type UseUserReturnType = {
  user: User | null
  login: (user: User) => void
  logout: () => void
}

export function useUser(): UseUserReturnType {
  const [user, setUser] = useRecoilState(userAtom);

  const logout = () => {
    localStorage.setItem(userKey, 'null');
    setUser(null);
  };

  const login = (user: User) => {
    localStorage.setItem(userKey, JSON.stringify(user));
    setUser(user);
  };

  return { user, login, logout };
}
