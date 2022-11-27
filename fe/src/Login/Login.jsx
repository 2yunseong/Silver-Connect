import { useNavigate } from 'react-router-dom';
import useInput from '../Hooks/useInput';
import './Login.css';

const Login = ({ setIsLogin }) => {
  const navigate = useNavigate();
  const email = useInput();
  const password = useInput();

  const onLogin = () => {
    setIsLogin(true);
    navigate('/');
  };

  return (
    <div className='login-container mx-auto my-10 w-4/5 justify-center text-center rounded-lg border'>
      <h1 className='font-bold text-5xl m-20'>로그인</h1>
      <div className='flex flex-col w-100'>
        <div className='flex justify-between text-justify w-2/3 mx-auto text-3xl my-6'>
          <span className='w-1/3'>이메일(ID):</span>
          <input
            className='w-2/3 border'
            type='text'
            placeholder='example@jnu.ac.kr'
            onChange={email.onChange}
            value={email.value}
          />
        </div>
        <div className='flex justify-between text-justify w-2/3 mx-auto text-3xl my-6'>
          <span className='w-1/3'>비밀번호:</span>
          <input
            className='w-2/3 border'
            type='password'
            placeholder='비밀번호'
            onChange={password.onChange}
            value={password.value}
          />
        </div>
        <button
          className='text-3xl text-white bg-blue-700 border-blue rounded-lg w-36 mx-auto my-10 h-12'
          onClick={onLogin}
        >
          로그인
        </button>
      </div>
    </div>
  );
};

export default Login;
