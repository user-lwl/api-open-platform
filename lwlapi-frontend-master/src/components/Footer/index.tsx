import { GithubOutlined } from '@ant-design/icons';
import { DefaultFooter } from '@ant-design/pro-components';
import '@umijs/max';
const Footer: React.FC = () => {
  const defaultMessage = 'user-lwl';
  // const currentYear = new Date().getFullYear();
  return (
    <DefaultFooter
      style={{
        background: 'none',
      }}
      // copyright={`${currentYear} ${defaultMessage}`}
      copyright={`${defaultMessage}`}
      links={[
        {
          key: 'API接口',
          title: 'API接口',
          href: 'https://github.com/user-lwl',
          blankTarget: true,
        },
        {
          key: 'github',
          title: <GithubOutlined />,
          href: 'https://github.com/user-lwl',
          blankTarget: true,
        },
        {
          key: 'user-lwl',
          title: 'user-lwl',
          href: 'https://github.com/user-lwl',
          blankTarget: true,
        },
      ]}
    />
  );
};
export default Footer;
