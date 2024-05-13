'use client'

import {
  Box,
  Flex,
  Text,
  IconButton,
  Stack,
  Collapse,
  Icon,
  Popover,
  PopoverTrigger,
  PopoverContent,
  useColorModeValue,
  useDisclosure,
} from '@chakra-ui/react'
import {
  HamburgerIcon,
  CloseIcon,
  ChevronDownIcon,
  ChevronRightIcon,
} from '@chakra-ui/icons'
import { useCallback, useEffect, useState } from 'react'
import { SymbolForPriceDataApi } from '../api/SymbolForPriceDataApi'
import { SymbolResponse } from '../models/SymbolResponse'
import { PriceDataApi } from '../api/PriceDataApi'
import { Price } from '../models/Price'

interface RequestSymbol<T>{
  data: T;
}

interface RequestPrice<T>{
  data: T;
}

export default function Navbar() {
  const { isOpen, onToggle } = useDisclosure()
  
  const[requestSymbol,setRequestSymbol]=useState<RequestSymbol<SymbolResponse[]>
  >({
    data: [],
    });

    const [lastPrice,setRequestPrice]=useState<RequestPrice<Price[]>
    >({
      data: [],
      });  

const fetchSymbol = useCallback(async () => {
  try {
    setRequestSymbol({ data: [] });
    const symbols = await SymbolForPriceDataApi.getSymbolForPrice();
    console.log(symbols);
    setRequestSymbol({ data: symbols.data });
  } catch (error) {
    console.error('Błąd podczas pobierania symboli:', error);
    setRequestSymbol({ data: [] });
  }
}, []);

useEffect(() => {
  fetchSymbol();
}, [fetchSymbol]);

const fetchLastPriceForSymbol = useCallback(async () => {
  try {
    setRequestPrice({ data: [] });
    const lastPrice = await PriceDataApi.getLastPriceBySymbol(symbol);
    console.log(lastPrice);
    setRequestPrice({ data: lastPrice.data });
  } catch (error) {
    console.error('Błąd podczas pobierania ceny:', error);
    setRequestPrice({ data: [] });    
  }
}, []);

useEffect(() => {
  fetchLastPriceForSymbol();
}, []);

  const handleLastPriceClick = async (symbol: string) => {
    await fetchLastPriceForSymbol(symbol);
  };

  return (
    <Box>
      <Flex
        bg={useColorModeValue('white', 'gray.800')}
        color={useColorModeValue('gray.600', 'white')}
        minH={'60px'}
        py={{ base: 2 }}
        px={{ base: 4 }}
        borderBottom={1}
        borderStyle={'solid'}
        borderColor={useColorModeValue('gray.200', 'gray.900')}
        align={'center'}>
        <Flex
          flex={{ base: 1, md: 'auto' }}
          ml={{ base: -2 }}
          display={{ base: 'flex', md: 'none' }}>
          <IconButton
            onClick={onToggle}
            icon={isOpen ? <CloseIcon w={3} h={3} /> : <HamburgerIcon w={5} h={5} />}
            variant={'ghost'}
            aria-label={'Toggle Navigation'}
          />
        </Flex>
        <Flex flex={{ base: 1 }} justify={{ base: 'center', md: 'start' }}>


          <Flex display={{ base: 'none', md: 'flex' }} ml={10}>
            <DesktopNav />
          </Flex>
        </Flex>
      </Flex>

      <Collapse in={isOpen} animateOpacity>

      </Collapse>
    </Box>
  )
}

const DesktopNav = () => {
  const linkColor = useColorModeValue('gray.600', 'gray.200')
  const linkHoverColor = useColorModeValue('gray.800', 'white')
  const popoverContentBgColor = useColorModeValue('white', 'gray.800')
  const [symbols, setSymbols] = useState([]);
  

  return (
    <Stack direction={'row'} spacing={4}>
      {NAV_ITEMS.map((navItem) => (
        <Box key={navItem.label}>
          <Popover trigger={'hover'} placement={'bottom-start'}>
            <PopoverTrigger>
              <Box
                as="a"
                p={2}
                href={navItem.href ?? '#'}
                fontSize={'sm'}
                fontWeight={500}
                color={linkColor}
                _hover={{
                  textDecoration: 'none',
                  color: linkHoverColor,
                }}>
                {navItem.label}
              </Box>
            </PopoverTrigger>

            {navItem.children && (
              <PopoverContent
                border={0}
                boxShadow={'xl'}
                bg={popoverContentBgColor}
                p={4}
                rounded={'xl'}
                minW={'sm'}>
                <Stack>
                  {navItem.children.map((child) => (
                    <DesktopSubNav key={child.label} {...child} />
                  ))}
                </Stack>
              </PopoverContent>
            )}
          </Popover>
        </Box>
      ))}
    </Stack>
  )
}

const DesktopSubNav = ({ label, href }: NavItem) => {
  return (
    <Box
      as="a"
      href={href}
      role={'group'}
      display={'block'}
      p={2}
      rounded={'md'}
      _hover={{ bg: useColorModeValue('pink.50', 'gray.900') }}>
      <Stack direction={'row'} align={'center'}>
        <Box>
          <Text
            transition={'all .3s ease'}
            _groupHover={{ color: 'pink.400' }}
            fontWeight={500}>
            {label}
          </Text>
        </Box>
        <Flex
          transition={'all .3s ease'}
          transform={'translateX(-10px)'}
          opacity={0}
          _groupHover={{ opacity: '100%', transform: 'translateX(0)' }}
          justify={'flex-end'}
          align={'center'}
          flex={1}>
          <Icon color={'pink.400'} w={5} h={5} as={ChevronRightIcon} />
        </Flex>
      </Stack>
    </Box>
  )
}

interface NavItem {
  label: string
  children?: Array<NavItem>
  href?: string
}

const NAV_ITEMS: Array<NavItem> = [
  {
    label: 'BTCUSDT',
    children: [
      {
        label: 'Ostatnia cena',
        href: '/last/BTCUSDT',
      },
      {
        label: 'Ostatni dzień',
        href: '#',
      },
    ],
  },
  {
    label: 'LTCUSDT',
    children: [
      {
        label: 'Ostatnia cena',
        href: '#',
      },
      {
        label: 'Ostatni dzień',
        href: '#',
      },
    ],
  },
  {
    label: 'ETHUSDT',
    children: [
      {
        label: 'Ostatnia cena',
        href: '#',
      },
      {
        label: 'Ostatni dzień',
        href: '#',
      },
    ],
  },
  {
    label: 'Ostatnia cena - wszystkie',
    href: '#',
  },
]