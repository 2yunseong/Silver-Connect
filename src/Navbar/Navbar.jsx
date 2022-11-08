import { Link } from 'react-router-dom';

function Navbar() {
  return (
    <div className="flex items-end mx-6 mt-6 pb-3 border-b-2 border-blue-300">
      <Link to={`/homepage`}>
        <img alt="logo" src="./images/logo.png" />
      </Link>
      <NavbarComponent link={'/homepage'} text={'일정'} />
      <NavbarComponent link={'/household'} text={'가구관리'} />
      <NavbarComponent link={'/mypage'} text={'마이페이지'} />
      <NavbarComponentRight link={'/logout'} text={'로그아웃'} />
    </div>
  );
}

function NavbarComponent(prop) {
  return (
    <Link to={prop.link} className="pl-6">
      <div className="w-1/2 border-t-4 border-blue-600"></div>
      <div className="text-4xl pt-2">
        <div className={prop.customCss}>{prop.text}</div>
      </div>
    </Link>
  );
}

function NavbarComponentRight(prop) {
  return (
    <div className="right-0 absolute pr-6">
      <NavbarComponent
        link={prop.link}
        text={prop.text}
        customCss={'!text-xl'}
      />
    </div>
  );
}

export default Navbar;
